package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CalcactivityMainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "calcactivity";
    private Button mjumpBt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mjumpBt = (Button) findViewById(R.id.jump);
        mjumpBt.setOnClickListener(this);//少了此句的后果
        Log.i(TAG, "onCreate");
    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    protected void OnRestart() {
        super.onRestart();
        Log.i(TAG, "OnRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(CalcactivityMainActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
