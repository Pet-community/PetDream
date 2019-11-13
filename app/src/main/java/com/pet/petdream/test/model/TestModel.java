package com.pet.petdream.test.model;

import android.util.Log;

import com.pet.petdream.base.bean.HttpResponseBean;
import com.pet.petdream.base.model.BaseModel;
import com.pet.petdream.base.model.OnModelListener;
import com.pet.petdream.base.util.HttpServer;
import com.pet.petdream.base.util.RequestClient;
import com.pet.petdream.test.bean.Test;
import com.pet.petdream.test.viewmodel.ITestViewmodel;
import com.pet.petdream.test.viewmodel.TestViewModel;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public   class TestModel extends BaseModel<HttpResponseBean<Test>> implements ITestModel{

    @Override
    public void login(String phone, String pwd) {

        RequestClient.getRequestClient().creat(HttpServer.class).find(phone,pwd).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HttpResponseBean<Test>>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(HttpResponseBean<Test> testHttpResponseBean) {
                        if (testHttpResponseBean.getCode()==200){
                            listener.onLoadFinish(testHttpResponseBean);
                        }
                        else{
                            listener.onLoadError(testHttpResponseBean.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                listener.onLoadError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }



}
