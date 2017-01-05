package com.example.controls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.ma_listView);
        String[] from = {"name", "sex"};
        int[] to = {android.R.id.text1, android.R.id.text2};//到底i传谁的id
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<String, String>();
            if (i % 2 == 1) {
                map.put("name", "小明" + (i / 2));
                map.put("sex", "男");
            } else {
                map.put("name", "小红" + (i / 2));
                map.put("sex", "女");
            }
            data.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(Main2Activity.this, data, android.R.layout.simple_list_item_2, from, to);
        listView.setAdapter(adapter);
    }
}
