package com.example.mytool.uitil;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amence on 2016/11/9.
 */

public class StackManager {
    /**
     * activity的计数器
     */
    public static final Map<String, List<Activity>> COUNTER = new HashMap<String, List<Activity>>();

    public static Activity sCurrentActivity = null;

    /**
     * activity创建时调用这个方法
     *
     * @param activity
     */
    public static void onActivityCreated(Activity activity) {
        String activityName = activity.getClass().getName();
        List<Activity> activities = COUNTER.get(activityName);
        if (activities == null) {
            activities = new ArrayList<Activity>();
            COUNTER.put(activityName, activities);
        }
        activities.add(activity);
    }


    /**
     * activity销毁时调用这个方法
     *
     * @param activity
     */
    public static void onActivityDestory(Activity activity) {
        String activityName = activity.getClass().getName();
        List<Activity> activities = COUNTER.get(activityName);
        if (activities != null) {
            activities.remove(activity);
        }
        if (activity == sCurrentActivity) {
            setCurrentActivity(null);
        }
    }

    /**
     * 设置当前activity
     *
     * @param activity
     */
    public static void setCurrentActivity(Activity activity) {
        sCurrentActivity = activity;
    }

    /**
     * 获取当前activity
     *
     * @return
     */
    public static Activity getCurrentActivity() {
        return sCurrentActivity;
    }

    /**
     * 清除所有的activity
     */
    public static final void finishAll() {
        for (String key : COUNTER.keySet()) {
            finishActivity(key);
        }
        COUNTER.clear();
    }

    /**
     * 清除指定的activity
     *
     * @param activityName
     */
    public static void finishActivity(String activityName) {
        List<Activity> activities = COUNTER.get(activityName);
        if (activities != null && !activities.isEmpty()) {
            for (Activity activity : activities) {
                if (activity != null) {
                    activity.finish();
                }
            }
            activities.clear();
        }
    }

    public static final boolean hasActivityInStack(String activityName) {
        List<Activity> activities = COUNTER.get(activityName);
        return activities != null && !activities.isEmpty();
    }


}
