package com.pet.petdream.base.util;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe app得所有网络接口
 */
public interface HttpServer {
     @POST("/searchAuthors")
     Observable  find(@Body String username);
}
