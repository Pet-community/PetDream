package com.pet.petdream.base.util;

import com.google.gson.Gson;
import com.pet.petdream.base.model.onModelListener;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe 网络请求类
 */
public   class RequestClient<T> {
    private static Retrofit.Builder retrofitBuilder;
    private static final  int DEFAULT_TIMEOUT=10;
    private static final String BASE_URL="https://api.apiopen.top";
    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置最长超时
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //断网重连
        builder.retryOnConnectionFailure(true);
        OkHttpClient okHttpClient = builder.build();
        retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson())).
                        addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                        client(okHttpClient);
                Retrofit retrofit=retrofitBuilder.baseUrl(BASE_URL).build();
                retrofit.create(HttpServer.class);

    }
    public Observable <T> request(Observable observable, T data){
      return   observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread());

    }
}
