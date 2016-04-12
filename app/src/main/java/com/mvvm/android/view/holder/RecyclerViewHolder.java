package com.mvvm.android.view.holder;


import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @param <R> 数据
 * @author hua.yin
 * @version 4.1.0
 * @since: 2015/7/10 23:52
 */
public abstract class RecyclerViewHolder<R> extends RecyclerView.ViewHolder {
    /**
     * @param itemView itemView
     */
    public RecyclerViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * @param itemView        itemView
     * @param onClickListener onClickListener
     */
    public RecyclerViewHolder(View itemView, View.OnClickListener onClickListener) {
        super(itemView);
        itemView.setOnClickListener(onClickListener);
    }


    /**
     * Look for a child view with the given id.  If this view has the given
     * id, return this view.
     *
     * @param id The id to search for.
     * @return The view that has the given id in the hierarchy or null
     */
    public View findViewById(int id) {
        return itemView.findViewById(id);
    }

    /**
     * 绑定数据
     *
     * @param data 数据
     */
    public abstract void onBind(R data);
}
