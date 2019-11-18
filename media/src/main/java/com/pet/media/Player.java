package com.pet.media;

import com.pet.media.inf.Native4JavaCallBack;

public class Player {
    public static final int PLAYER_MSG_CODE = 1;

    static {
        System.loadLibrary("native-lib");
    }

    Native4JavaCallBack callBack;

    public Player(Native4JavaCallBack callBack) {
        this.callBack = callBack;
        init();
    }

    public native void init();

    /**
     * 准备播放
     *
     * @param path 媒体文件地址或网咯地址
     */
    public native void prepare(String path);


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * 从Native层回调
     *
     * @param isSuccess prepare state
     */
    private void callPrepare(boolean isSuccess) {
        if (callBack != null) {
            callBack.OnCallPrepare(isSuccess);
        }
    }

}
