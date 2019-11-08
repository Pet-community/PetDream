package com.pet.petdream.base.viewmodel;

import android.view.View;

import com.pet.petdream.base.view.IBaseView;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public interface IBaseViewModel<V extends IBaseView>{
    /**
     * 关联view
     */
    void attachView(V view);
    /**
     * 解除关联得view
     */
    void detachView();
}
