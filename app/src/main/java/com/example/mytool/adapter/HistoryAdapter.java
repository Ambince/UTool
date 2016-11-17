package com.example.mytool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mytool.R;
import com.example.mytool.bean.history.HistoryResult;

import java.util.List;

/**
 * Created by Amence on 2016/11/17.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryHolder> {
    private List<HistoryResult> result;
    private Context mContext;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public HistoryAdapter(List<HistoryResult> result, Context context) {
        this.result = result;
        this.mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new HistoryHolder(LayoutInflater.from(mContext).inflate(R.layout.history_item, null));
    }

    @Override
    public void onBindViewHolder(final HistoryHolder holder, final int position) {
        holder.mTextTitle.setText(result.get(position).getTitle());
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(v, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(v, pos);
                    return false;
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return result.size();
    }
}


class HistoryHolder extends RecyclerView.ViewHolder {
    public TextView mTextTitle;

    public HistoryHolder(View itemView) {
        super(itemView);
        mTextTitle = (TextView) itemView.findViewById(R.id.text_title);
    }
}



