package com.pet.petdream.base.model;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public interface onModelListener<T>{
    /**
     * 请求成功后得方法
     * @param baseModel
     * @param data
     */
    void onLoadFinish(BaseModel baseModel,T data);

    /**
     * 请求失败后得方法
     */
    void onLoadError(BaseModel baseModel,String erro);

}
