package com.pet.petdream;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.pet.petdream.base.ui.BaseActivity;
import com.pet.petdream.databinding.ActivityMainBinding;
import com.pet.petdream.test.TestViewModel;
import com.pet.petdream.test.bean.Test;
import com.pet.petdream.test.view.ITestView;


public class MainActivity extends BaseActivity<ActivityMainBinding, TestViewModel> implements ITestView {
    Test test=new Test();
    @Override
    protected void initView() {
    viewModel.attachView(this);

    viewModel.loadTestDate();
    }

    @Override
    protected int getVariableId() {
        return BR.TestData;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected TestViewModel getViewModel() {
        return new TestViewModel();
    }

    @Override
    public void onErro(String erro) {
        test.setUsername(erro);
        viewDataBinding.setTestData(test);


    }

    @Override
    public void onRespo(Test data) {
        viewDataBinding.setTestData(data);

    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    public void onEmptyResponse() {

    }
}
