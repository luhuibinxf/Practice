package com.example.controls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;

public class TwoActivity extends AppCompatActivity {
    Button mbt;
    ListView listView;
    private ArrayList<String> lise = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
//        mbt = (Button) findViewById(R.id.two);
        listView = (ListView) findViewById(R.id.listView_two);
//        mbt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = getIntent();
//                Bundle bundle = intent.getExtras();
//                bundle.putString("ok", "yes");
//                intent.putExtras(bundle);
//                setResult(RESULT_OK, intent);//intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
//                finish();//此处一定要调用finish()方法
//            }
//        });
        for (int i = 0; i < 20; i++) {
            lise.add("测试数据" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lise);
        listView.setAdapter(adapter);
    }
}
