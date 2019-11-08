package com.pet.petdream.base.model;

import android.os.Handler;

/**
 * @author wuyang
 * @create 2019/11/7
 * @Describe
 */
public class BaseModel<T> {
    protected onModelListener onModelListener;

    protected void loadSuccess(T data) {
        if (onModelListener != null) {
            onModelListener.onLoadFinish(this, data);
        }
    }

    protected void loadFailed(String error) {
        if (onModelListener != null) {
            onModelListener.onLoadError(this, error);
        }

    }
    public void setOnModelListener(onModelListener<T> onModelListener) {
        this.onModelListener = onModelListener;
    }
    public void removeOnModelListener(){
        this.onModelListener = null;
    }
}
