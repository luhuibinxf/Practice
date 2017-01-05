package com.example.controls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mbt;
    Bundle bundle;
    String str1 = "yes";
    TextView minfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbt = (Button) findViewById(R.id.button_one);
        mbt.setOnClickListener(this);
        mbt = (Button) findViewById(R.id.two);
        mbt.setOnClickListener(this);
        mbt = (Button) findViewById(R.id.bt_3);
        mbt.setOnClickListener(this);
        mbt = (Button) findViewById(R.id.bt_4);
        mbt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.button_one:
                intent = new Intent(MainActivity.this, OneActivity.class);
                startActivity(intent);
                break;
            case R.id.two:
                intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_3:
                intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.bt_4:
                intent = new Intent(MainActivity.this, FourActivity.class);
                startActivity(intent);
                break;
        }
    }


}
