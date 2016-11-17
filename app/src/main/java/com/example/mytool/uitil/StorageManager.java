package com.example.mytool.uitil;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Amence on 2016/11/6.
 */

public class StorageManager {

    private static final String EXTERNAL_STORAGE_PATH = Environment.getExternalStorageDirectory().getPath();
    private static List<String> sSDVolums = null;
    private static final Object lock = new Object();
    public static  List<String> getSDVolumns() {
        synchronized(lock) {
            if(sSDVolums == null) {
                List<String> mounts = readMountsFile();
                List<String> volds = readVoldFile();
                sSDVolums = compareMountsWithVold( mounts, volds);
            }
            return sSDVolums;
        }

    }

    public static File getExternalStorageDirectory() {
        File sdcard = Environment.getExternalStorageDirectory();
        if (sdcard.canWrite()) {
            return sdcard;
        } else if (getSDVolumns() != null) {
            for (String path : sSDVolums) {
                if (!sdcard.getAbsolutePath().endsWith(path)) {
                    return new File(path);
                }
            }
        }
        return sdcard;
    }

    public static void onStroageChanged(){
        synchronized(lock) {
            sSDVolums = null;
        }
    }

    private static List<String> readMountsFile() {
        /*
         * Scan the /proc/mounts file and look for lines like this: /dev/block/vold/179:1 /mnt/sdcard vfat
         * rw,dirsync,nosuid,nodev,noexec ,relatime,uid=1000,gid=1015,fmask=0602,dmask=0602,allow_utime=0020,
         * codepage=cp437,iocharset= iso8859-1,shortname=mixed,utf8,errors=remount-ro 0 0 When one is found, split it into its
         * elements and then pull out the path to the that mount point and add it to the arraylist
         */

        // some mount files don't list the default
        // path first, so we add it here to
        // ensure that it is first in our list
        List<String> mounts = new ArrayList<String>();
//        List<String> partitions = new ArrayList<String>();
        mounts.add( EXTERNAL_STORAGE_PATH);
        try {
            Scanner scanner = new Scanner( new File( "/proc/mounts"));
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                if(line.startsWith( "/dev/block/vold/") || line.startsWith( "/dev/block//vold/")) {
                    String[] lineElements = line.split( " ");
                    //String partition = lineElements[0];
                    String element = lineElements[1];
                    // don't add the default mount path
                    // it's already in the list.
                    if(!element.equals( EXTERNAL_STORAGE_PATH)) {
//                        if(!partitions.contains( partition)) {
//                            partitions.add( partition);
//                        }
                        mounts.add( element);
                    }
//                    else {
//                        File dir = new File( element);
//                        if(dir.&& !partitions.contains( partition)) {
//                            partitions.add( partition);
//
//                        }
//                    }

                }
            }
        } catch(Exception e) {
            //e.printStackTrace();
        }
        return mounts;
    }

    private static List<String> readVoldFile() {
        // read /etc/vold.conf or /etc/vold.fstab (it depends on version what
        // config file is present)
        List<String> vold = null;
        Scanner scanner = null;
        try {
            try {
                scanner = new Scanner( new File( "/system/etc/vold.fstab"));
            } catch(FileNotFoundException e1) {
                //e1.printStackTrace();
                scanner = new Scanner( new File( "/system/etc/vold.conf"));
            }
            vold = new ArrayList<String>();
            vold.add( EXTERNAL_STORAGE_PATH);
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                if(TextUtils.isEmpty( line))
                    continue;
                line = line.trim();
                if(line.startsWith( "dev_mount")) {
                    String[] lineElements = line.split( " ");
                    if(lineElements.length < 3)
                        continue;
                    String element = lineElements[2];
                    if(element.contains( ":"))
                        element = element.substring( 0, element.indexOf( ":"));
                    // ignore default path
                    if(!element.equals( EXTERNAL_STORAGE_PATH))
                        vold.add( element);
                }
                else if(line.startsWith( "mount_point")) {
                    String element = line.replaceAll( "mount_point", "").trim();
                    if(!element.equals( EXTERNAL_STORAGE_PATH))
                        vold.add( element);
                }
            }
        } catch(Exception e) {
            // e.printStackTrace();
        }
        return vold;
    }

    private static List<String> compareMountsWithVold(List<String> mounts, List<String> volds) {
        /*
         * 有时候这两个list中的数据并不相同，我们只需要取两个list的交集部分。
         */
        for(int i = mounts.size() - 1; i >= 0; i--) {
            String mount = mounts.get( i);
            File root = new File( mount);
            // 判断目录是否存在并且可读
            if(!root.exists() || !root.isDirectory() || !root.canWrite()) {
                mounts.remove( i);
                continue;
            }
            if(volds != null && !volds.contains( mount)) {
                mounts.remove( i);
            }
        }
        // 清除无用数据
        if(volds != null) {
            volds.clear();
        }
        // FIXME 有可能出现目录不一样，但是link到是同一个地方，暂且认为
        return mounts;
    }

    public static long getTotalMemory() {
        String file_path = "/proc/meminfo";// 系统内存信息文件
        String ram_info;
        String[] arrayOfRam;
        long initial_memory = 0l;
        try {
            FileReader fr = new FileReader( file_path);
            BufferedReader localBufferedReader = new BufferedReader( fr, 8192);
            // 读取meminfo第一行，系统总内存大小
            ram_info = localBufferedReader.readLine();
            if (ram_info == null) {
                return initial_memory;
            }
            arrayOfRam = ram_info.split( "\\s+");// 实现多个空格切割的效果
            initial_memory = Integer.parseInt(arrayOfRam[1]) * 1024;// 获得系统总内存，单位是KB，乘以1024转换为Byte
            localBufferedReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return initial_memory;
    }

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager)context.getSystemService( Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo( memoryInfo);
        return memoryInfo.availMem;
    }

}
