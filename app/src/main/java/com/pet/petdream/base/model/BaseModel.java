package com.pet.petdream.base.model;

/**
 * @author wuyang
 * @create 2019/11/7
 * @Describe
 */
public  class BaseModel<T> {
    protected OnModelListener<T> listener;

    public void setListener(OnModelListener<T> listener) {
        this.listener = listener;
    }

    public OnModelListener getListener() {
        return listener;
    }

    protected void loadSuccess(T data) {
        if (listener != null) {
            listener.onLoadFinish(data);
        }
    }

    /**
     * 加载失败，回调至ViewModel
     *
     * @param error
     */
    protected void loadFailed(String error) {
        if (listener != null) {
            listener.onLoadError(error);
        }
    }
}
