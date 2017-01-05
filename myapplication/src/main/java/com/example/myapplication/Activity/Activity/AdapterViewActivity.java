package com.example.myapplication.Activity.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class AdapterViewActivity extends AppCompatActivity implements View.OnClickListener {
    Button mbt;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view);
        mbt = (Button) findViewById(R.id.m_down);
        mbt.setOnClickListener(this);//到底多不多余
        mbt = (Button) findViewById(R.id.m_list);
        mbt.setOnClickListener(this);
        mbt = (Button) findViewById(R.id.m_view);
        mbt.setOnClickListener(this);
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()) {
//                    case R.id.m_down:
//                        intent = new Intent(AdapterViewActivity.this, SpinnerActivity.class);//传的位置???
//                        startActivity(intent);
//                        break;
//                    case R.id.m_list:
//                        intent = new Intent(AdapterViewActivity.this, null);//传的位置????
//                        startActivity(intent);
//                        break;
//                    case R.id.m_view:
//                        intent = new Intent(AdapterViewActivity.this, GridViewActivity.class);//传的位置????
//                        startActivity(intent);
//                        break;
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.m_down:
                intent = new Intent(AdapterViewActivity.this, SpinnerActivity.class);//传的位置???
                startActivity(intent);
                break;
            case R.id.m_list:
                intent = new Intent(AdapterViewActivity.this, ExpandableListViewActivity.class);//传的位置????
                startActivity(intent);
                break;
            case R.id.m_view:
                intent = new Intent(AdapterViewActivity.this, GridViewActivity.class);//传的位置????
                startActivity(intent);
                break;
        }
    }
}
