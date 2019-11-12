package com.pet.media;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.pet.media.inf.Native4JavaCallBack;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player player = new Player(new Native4JavaCallBack() {
            @Override
            public void OnCallPrepare(boolean isSuccess) {
                Log.e(TAG, "OnCallPrepare: prepare" + (isSuccess ? "成功" : "失败"));
            }
        });
        player.prepare("asdadas");
    }
}
