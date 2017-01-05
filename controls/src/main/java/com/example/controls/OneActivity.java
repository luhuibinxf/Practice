package com.example.controls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.app.Activity.RESULT_OK;

public class OneActivity extends AppCompatActivity {
    Button mbt;
    ListView listView;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
//        mbt = (Button) findViewById(R.id.button_one);
//        mbt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = getIntent();
//                Bundle bundle = new Bundle();
//                bundle.putString("ok", "yes");
//                intent.putExtras(bundle);
//                setResult(RESULT_OK, intent);//intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
//                finish();//此处一定要调用finish()方法
//            }
//        });
        listView = (ListView) this.findViewById(R.id.listView);
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        String[] from = {"name", "sex", "age"};
        int[] to = {R.id.tv_name, R.id.tv_sex, R.id.tv_age};//传给谁 下面找
        for (int i = 0; i < 20; i++) {
            Map<String, String> map = new HashMap<String, String>();
            if (i % 2 == 1) {
                map.put("name", "小鹿" + (i / 2));
                map.put("sex", "男");
                map.put("age", "2" + (i / 2));
            } else {
                map.put("name", "小花" + (i / 2));
                map.put("sex", "女");
                map.put("age", "3" + (i / 2));
            }
            data.add(map);
        }
        adapter = new SimpleAdapter(OneActivity.this, data, R.layout.activity_three, from, to);
        listView.setAdapter(adapter);
    }

}
