package com.pet.petdream.test;

import com.pet.petdream.base.model.BaseModel;
import com.pet.petdream.base.model.onModelListener;
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
public class TestViewModel extends BaseViewModel <ITestView, TestModel>
        implements ITestModel, onModelListener<Test>{
    @Override
    public void loadTestDate() {
        if (isAttachView()){
            getview().onShowLoading();
        }
        model.loadTestDate();

    }




    @Override
    protected TestModel createModel() {
TestModel testModel=new TestModel();
testModel.setOnModelListener(this);
    return testModel;
    }

    @Override
    public void onLoadFinish(BaseModel baseModel, Test t) {
    getview().onHideLoading();
    getview().onRespo(t);

    }

    @Override
    public void onLoadError(BaseModel baseModel, String erro) {
getview().onErro("xxx");
    }
}
