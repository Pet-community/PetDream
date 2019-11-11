package com.pet.media;

public class Player {
    static {
        System.loadLibrary("native-lib");
    }

    public  native void test();
}
