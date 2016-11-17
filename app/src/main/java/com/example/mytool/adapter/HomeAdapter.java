package com.example.mytool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytool.R;

/**
 * Created by Amence on 2016/11/3.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private Context mContext;
    private String[] mData;
    private int[] mPhoto;

    //设置点击事件
    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    public HomeAdapter(Context context, String[] data, int[] photo) {
        this.mContext = context;
        this.mData = data;
        this.mPhoto = photo;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler, null));


        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.textView.setText(mData[position]);
        holder.imageView.setImageResource(mPhoto[position]);
        if (mListener != null) {

            //设置点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mListener.onItemClick(holder.itemView, pos);
                }
            });

            //设置长按事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });

        }


    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recyclerText_item);
            imageView = (ImageView) itemView.findViewById(R.id.recyclerImage_item);

        }
    }


}



