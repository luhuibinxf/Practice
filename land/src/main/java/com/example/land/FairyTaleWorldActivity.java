package com.example.land;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FairyTaleWorldActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "FairyTaleWorldActivity";
    private Button mjumpBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fairy_tale_world);
        mjumpBt = (Button) findViewById(R.id.button);
        mjumpBt.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(FairyTaleWorldActivity.this, FailActivity.class);//注意（）中放要连接的类的起止位置
        startActivity(intent);
    }
}
