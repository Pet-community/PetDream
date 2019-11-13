package com.pet.petdream.base.util;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe 网络请求类
 */
public   class RequestClient {
    private  static RequestClient requestClient=new RequestClient();
    private static Retrofit.Builder retrofitBuilder;
    private static final  int DEFAULT_TIMEOUT=10;
    private static Retrofit retrofit;
    private static final String BASE_URL="http://test.instrall.cn";
    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置最长超时
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //断网重连
        builder.retryOnConnectionFailure(true);
        OkHttpClient okHttpClient = builder.build();
        retrofitBuilder = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson())).

                        client(okHttpClient);
                 retrofit=retrofitBuilder.baseUrl(BASE_URL).build();
                retrofit.create(HttpServer.class);

    }
    private  RequestClient(){

    }
    public static RequestClient getRequestClient(){
        return  requestClient;
    }
   public  <T>  T creat(Class<T> tClass){
        return  retrofit.create(tClass);
   }

}
