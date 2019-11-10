package com.pet.petdream.base.util;

import com.pet.petdream.base.bean.HttpResponseBean;
import com.pet.petdream.test.bean.Test;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe app得所有网络接口
 */
public interface HttpServer {
     @GET("/login")
     Observable<HttpResponseBean<Test>>  find(@Query("name") String username, @Query("pwd") String password);
}
