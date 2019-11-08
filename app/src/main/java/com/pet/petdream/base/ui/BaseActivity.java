package com.pet.petdream.base.ui;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import com.pet.petdream.base.viewmodel.IBaseViewModel;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public  abstract class BaseActivity <V extends ViewDataBinding,VM extends IBaseViewModel> extends Activity {
    protected V viewDataBinding;
    protected VM viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel=getViewModel();
        viewDataBinding= DataBindingUtil.setContentView(this,getLayoutId());
        if (getVariableId()==0&& null!=viewModel){
            viewDataBinding.setVariable(getVariableId(),viewModel);
        }
        viewDataBinding.executePendingBindings();
        initView();
    }

    /**
     * 初始化操作
     */
    protected abstract void initView();

    /**
     * 获取viewModel得ID
     *
     * @return
     */
    protected abstract int getVariableId();

    /**
     * 获取布局ID
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 获取viewModel
     * @return viewmodel
     */
    protected abstract VM getViewModel();
}
