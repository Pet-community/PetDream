package com.pet.petdream.base.view;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public interface IBaseView {
    /**
     * 正在加载
     */
    void onShowLoading();
    /**
     * 加载完成
     */
    void onHideLoading();
    /**
     * 数据为空
     */
    void onEmptyResponse();

}
