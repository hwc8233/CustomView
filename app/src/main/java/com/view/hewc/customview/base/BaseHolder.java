package com.view.hewc.customview.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.view.hewc.customview.base.utils.KnifeUtil;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by hewc(破天) on 2017/11/16.
 * recyclerView  专用Holder
 */
public abstract class BaseHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected OnViewClickListener mOnViewCliclListener = null;

    protected final String TAG = this.getClass().getSimpleName();

    public BaseHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);//点击事件
        AutoUtils.autoSize(itemView);//适配
        KnifeUtil.bindTarget(this, itemView);//绑定

    }

    /**
     * 设置数据
     * 刷新界面
     *
     * @param data
     * @param position
     */
    public abstract void setData(T data, int position);

    /**
     * 释放资源
     */
    protected void onRelase() {
    }

    @Override
    public void onClick(View v) {
        if (mOnViewCliclListener != null) {
            mOnViewCliclListener.onViewClick(v, this.getPosition());
        }
    }

    public interface OnViewClickListener {
        void onViewClick(View view, int position);
    }

    public void setOnItemClickListener(OnViewClickListener listener) {
        this.mOnViewCliclListener = listener;
    }
}
