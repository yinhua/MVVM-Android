package com.mvvm.android.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mvvm.android.view.holder.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author hua.yin
 * @version 4.1.0
 * @since: 2015/7/6 17:55
 */
public abstract class RecyclerAdapter extends RecyclerView.Adapter {
    private List mItemList = null;
    private List<Integer> mTypeList = null;

    /**
     * 构造方法
     */
    public RecyclerAdapter() {
        mItemList = new ArrayList<>();
        mTypeList = new ArrayList<>();
    }

    /**
     * 添加灵敏据
     *
     * @param data 数据对象
     * @param type 类型
     */
    public void addData(Object data, int type) {
        if (data != null) {
            mItemList.add(data);
            mTypeList.add(type);
        }
    }

    /**
     * 添加灵敏据
     *
     * @param dataList 数据集合
     * @param type     类型
     */
    public void addDataList(List dataList, int type) {
        if (dataList != null) {
            mItemList.addAll(dataList);
            for (int i = 0; i < dataList.size(); i++) {
                mTypeList.add(type);
            }
        }
    }

    /**
     * 添加灵敏据
     *
     * @param index 下标
     * @param data  数据对象
     */
    public void addData(int index, Object data) {
        if (data != null && index >= 0 && index <= mTypeList.size()) {
            mItemList.add(index, data);
            mTypeList.add(index, 0);
        }
    }

    /**
     * 添加灵敏据
     *
     * @param index 下标
     * @param data  数据对象
     * @param type  类型
     */
    public void addData(int index, Object data, int type) {
        if (data != null && index >= 0 && index <= mTypeList.size()) {
            mItemList.add(index, data);
            mTypeList.add(index, type);
        }
    }

    public void swapDataItem(int fromPosition, int toPosition) {
        if (fromPosition >=0 && fromPosition < mItemList.size()
                && toPosition >=0 && toPosition < mItemList.size()) {
            Collections.swap(mItemList, fromPosition, toPosition);
        }
    }

    public void updateData(int index, Object data) {
        if (data != null && index >= 0 && index < mItemList.size()) {
            mItemList.set(index, data);
        }
    }

    /**
     * 添加灵敏据
     *
     * @param index    index
     * @param dataList 数据集合
     * @param type     类型
     */
    public void addDataList(int index, List dataList, int type) {
        if (dataList != null && index >= 0 && index <= mTypeList.size()) {
            mItemList.addAll(index, dataList);
            for (int i = 0; i < dataList.size(); i++) {
                mTypeList.add(index, type);
            }
        }
    }

    /**
     * 添加灵敏据
     *
     * @param index    index
     * @param dataList 数据集合
     */
    public void addDataList(int index, List dataList) {
        mItemList.addAll(index, dataList);
        for (int i = 0; i < dataList.size(); i++) {
            mTypeList.add(index, 0);
        }

    }

    /**
     * 检查index
     *
     * @param index index
     * @return 是否有效
     */
    public boolean checkIndex(int index) {
        return index >= 0 && index < mTypeList.size();
    }

    /**
     * @param index 删除数据
     */
    public void remove(int index) {
        if (!checkIndex(index)) {
            return;
        }
        mTypeList.remove(index);
        mItemList.remove(index);
    }

    /**
     * @param type 根据类型删除数据
     */
    public void removeByType(int type) {
        Iterator<Integer> iterator = mTypeList.iterator();
        Iterator itemIterator = mItemList.iterator();
        while (iterator.hasNext()) {
            Integer typeValue = iterator.next();
            itemIterator.next();
            if (type == typeValue) {
                iterator.remove();
                itemIterator.remove();
            }
        }
    }

    /**
     * 清除数据
     */
    public void clear() {
        mItemList.clear();
        mTypeList.clear();
    }

    @Override
    public int getItemViewType(int position) {
        if (mTypeList.size() > 0 && checkIndex(position)) {
            return mTypeList.get(position);
        } else {
            return 0;
        }
    }

    public List getItemListByType(int type) {
        List list = new ArrayList();
        for (int i = 0; i < mTypeList.size(); i++) {
            if (type == mTypeList.get(i)) {
                list.add(getItem(i));
            }
        }
        return list;
    }

    public int getFirstPositionByType(int type) {
        return mTypeList.indexOf(type);
    }

    public int getLastPositionByType(int type) {
        return mTypeList.lastIndexOf(type);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return onCreateViewTypeHolder(viewGroup, viewType);
    }

    /**
     * 是否存在此类型
     * @param type 类型
     * @return true|false
     */
    public boolean isExistType(int type) {
        return mTypeList.contains(type);
    }

    /**
     * @param position 下标
     * @return 获取当前item数据
     */
    public Object getItem(int position) {
        //todo 此异常捕获，用于友盟统计,方便查看具体崩溃信息
        try {
            return mItemList.get(position);
        } catch (IndexOutOfBoundsException e) {
            StringBuilder errorMsg = new StringBuilder(e.getMessage());
            errorMsg.append(" ").append(" class:" + getClass() + " ");
            throw new IndexOutOfBoundsException(errorMsg.toString());
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof RecyclerViewHolder) {
            RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) viewHolder;
            recyclerViewHolder.onBind(getItem(position));
        }
    }

    /**
     * 根据类型刷新数据
     *
     * @param type 类型
     */
    public void notifyItemRangeChanged(int type) {
        for (int i = 0; i < mTypeList.size(); i++) {
            int typeValue = mTypeList.get(i);
            if (type == typeValue) {
                notifyItemChanged(i);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    /**
     * 创建不同类型的view holder
     *
     * @param viewGroup view容器
     * @param viewType  view类型
     * @return 返回view holder
     */
    public abstract RecyclerView.ViewHolder onCreateViewTypeHolder(ViewGroup viewGroup , int viewType);

}
