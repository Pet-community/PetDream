package com.pet.petdream.base.model;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public interface OnModelListener<T>{

    /**
     * 请求失败后得方法
     */
    void onLoadError(String erro);
    /**
     * 请求成功得方法
     */
    void onLoadFinish(T data);


}
