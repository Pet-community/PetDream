package com.pet.petdream.test.model;

import android.util.Log;

import com.pet.petdream.base.bean.HttpResponseBean;
import com.pet.petdream.base.model.BaseModel;
import com.pet.petdream.base.util.HttpServer;
import com.pet.petdream.base.util.RequestClient;
import com.pet.petdream.test.bean.Test;

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
public class TestModel extends BaseModel<Test> implements ITestModel{
HttpServer httpServer;

    @Override
    public void loadTestDate() {
        HttpServer httpServer=  RequestClient.getRequestClient().creat(HttpServer.class);
        httpServer.find("admin","123").
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<HttpResponseBean<Test>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HttpResponseBean<Test> testHttpResponseBean) {
                        Log.i("WUYANG","响应值："+testHttpResponseBean.getCode());
                    if (testHttpResponseBean.getCode()!=200){
                        loadFailed(testHttpResponseBean.getMessage());

                    }
                    else {
                        loadSuccess(testHttpResponseBean.getData());
                    }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadFailed(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
