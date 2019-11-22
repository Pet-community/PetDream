package com.pet.petdream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.pet.petdream.base.ui.BaseActivity;

import com.pet.petdream.databinding.ActivityLoginBinding;
import com.pet.petdream.test.bean.Test;
import com.pet.petdream.test.view.ITestView;
import com.pet.petdream.test.viewmodel.TestViewModel;


public class MainActivity extends BaseActivity<ActivityLoginBinding, TestViewModel> implements ITestView {
    Test test=new Test();
    @Override
    protected void initView() {
    viewModel.attachView(this);
    viewDataBinding.setHandlers(this);




    }

    @Override
    protected int getVariableId() {
        return  0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
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
public void getCodeEven(View view){
        Toast.makeText(this,"获取到验证码：8888",Toast.LENGTH_SHORT).show();
    final Button button= (Button) view;
    button.setEnabled(false);
         CountDownTimer countDownTimer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {
                button.setText(l/1000+"秒后重新获取");




            }

            @Override
            public void onFinish() {
                button.setText("获取验证码");
                button.setEnabled(true);
            }
        };
         countDownTimer.start();
}
}
