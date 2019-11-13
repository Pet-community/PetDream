package com.pet.petdream.test.viewmodel;

import android.util.Log;

import com.pet.petdream.base.bean.HttpResponseBean;
import com.pet.petdream.base.model.BaseModel;
import com.pet.petdream.base.model.OnModelListener;
import com.pet.petdream.base.viewmodel.BaseViewModel;
import com.pet.petdream.test.bean.Test;
import com.pet.petdream.test.model.ITestModel;
import com.pet.petdream.test.model.TestModel;
import com.pet.petdream.test.view.ITestView;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public class TestViewModel extends BaseViewModel<ITestView, TestModel> implements OnModelListener<HttpResponseBean<Test>>, ITestModel {
    TestModel testModel;

    @Override
    protected TestModel createModel() {


        testModel = new TestModel();
        testModel.setListener(this);
        return testModel;

    }



    @Override
    public void login(String phone, String pwd) {
        if (isAttachView()) {
            model.login(phone, pwd);
        }
    }


    @Override
    public void onLoadError(String erro) {
        getview().onErro(erro);

    }

    @Override
    public void onLoadFinish(HttpResponseBean<Test> data) {


    }
}
