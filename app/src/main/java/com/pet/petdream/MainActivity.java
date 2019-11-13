package com.pet.petdream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.pet.petdream.base.ui.BaseActivity;
import com.pet.petdream.databinding.ActivityMainBinding;

import com.pet.petdream.databinding.ActivityPhoneLoginBinding;
import com.pet.petdream.test.bean.Test;
import com.pet.petdream.test.view.ITestView;
import com.pet.petdream.test.viewmodel.TestViewModel;


public class MainActivity extends BaseActivity<ActivityPhoneLoginBinding, TestViewModel> implements ITestView {
    Test test=new Test();
    @Override
    protected void initView() {
    viewModel.attachView(this);

    viewModel.login("123","123");
    }

    @Override
    protected int getVariableId() {
        return BR.TestData;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_phone_login;
    }

    @Override
    protected TestViewModel getViewModel() {
        return new TestViewModel();
    }

    @Override
    public void onErro(String erro) {

        Toast.makeText(this,erro,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onRespo(Test data) {


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
