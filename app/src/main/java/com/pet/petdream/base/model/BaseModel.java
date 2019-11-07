package com.pet.petdream.base.model;

import android.os.Handler;

/**
 * @author wuyang
 * @create 2019/11/7
 * @Describe
 */
public class BaseModel {
    public void send(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },200);
    }
}
