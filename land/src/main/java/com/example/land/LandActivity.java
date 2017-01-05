package com.example.land;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LandActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "LandActivity";
    private Button mjumpBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        mjumpBt = (Button) findViewById(R.id.jump);
//        mjumpBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        mjumpBt.setOnClickListener(this);
        Log.i(TAG, "onCreate:创建");
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
        Intent intent = new Intent();
        //设置操作为打电话
        intent.setAction(Intent.ACTION_CALL);
        //通过Uri设置电话号码
        intent.setData(Uri.parse("tel:15562558304"));
        startActivity(intent);


//        Intent intent = new Intent(LandActivity.this, FairyTaleWorldActivity.class);
//        startActivity(intent);
    }
}
