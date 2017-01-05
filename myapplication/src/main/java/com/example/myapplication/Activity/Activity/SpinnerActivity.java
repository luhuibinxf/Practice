package com.example.myapplication.Activity.Activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myapplication.R;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        // 获取界面布局文件中的Spinner组件如果我们使用Spinner时已经可以确定下拉列表里的列表项，则完全不需要编写代码，
        //只需要为Spinner指定android:entries属性即可实现Spinner；
        //如果程序需要在运行时动态的决定Spinner的列表项，或程序需要对Spinner的列表项进行定制，则可使用Adapter为Spinner提供列表项。
        spinner = (Spinner) findViewById(R.id.spinner2);
        String[] arr = {"小王", "小张", "小小", "小鹅"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr);// 创建ArrayAdapter对象
        spinner.setPopupBackgroundDrawable(getResources().getDrawable(R.mipmap.bomb0));//加背景
        spinner.setAdapter(adapter); // 为Spinner设置Adapter
    }
}
