package com.example.land;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FailActivity extends AppCompatActivity {
    private final String TAG = "FailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart:开始");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume:简历");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart:重新启动");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause:暂停");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop:停止");
    }

    protected void onDestory() {
        super.onDestroy();
        Log.i(TAG, "onDestory:销毁");
    }
}
