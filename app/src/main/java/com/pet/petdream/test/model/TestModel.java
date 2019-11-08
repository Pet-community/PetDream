package com.pet.petdream.test.model;

import com.pet.petdream.base.model.BaseModel;
import com.pet.petdream.base.util.HttpServer;
import com.pet.petdream.base.util.RequestClient;
import com.pet.petdream.test.bean.Test;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public class TestModel extends BaseModel<Test> implements ITestModel{
HttpServer httpServer;
    @Override
    public void loadTestDate() {
        RequestClient<Test> requestClient=new RequestClient<>();
        requestClient.request(httpServer.find("xxx"),new Test()).subscribe(new Observer<Test>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Test test) {
                loadSuccess(test);

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
