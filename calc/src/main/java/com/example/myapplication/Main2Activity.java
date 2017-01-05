package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "Main2Activity";//这样写的好处
    private Button mjumpBt;//注意写法
    private TextView metextView1;//注意写法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mjumpBt = (Button) findViewById(R.id.jump);//注意写法
        metextView1 = (TextView) findViewById(R.id.jump);//注意写法
        mjumpBt.setOnClickListener(this);//没有实现View.OnClickListener
        metextView1.setOnClickListener(this);//有错，及其原因
        new View.OnClickListener() {//匿名内部类
            
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();//注意（）中放要连接的类的起止位置
                startActivity(intent);//需注意上面穿的参数
            }
        };
        Log.i(TAG, "onCreate:创建时的回调函数");
    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart:起点");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart:重新启动");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume:简历");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause:暂停");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop:停止");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy:破坏");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jump:
                Intent intent = new Intent();//注意（）中放要连接的类的起始位置
                startActivity(intent);//位置
                break;
            case R.id.textView:
//             Toast.makeText();//注意（）中放要连接的类的起始位置及文本信息.show(实例如下)
//                Toast.makeText(QQActivity.this,"文本显示",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
