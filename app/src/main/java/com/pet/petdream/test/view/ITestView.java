package com.pet.petdream.test.view;

import com.pet.petdream.base.view.IBaseView;
import com.pet.petdream.test.bean.Test;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public interface ITestView extends IBaseView {
    void onErro(String erro);
    void onRespo(Test data);
}
