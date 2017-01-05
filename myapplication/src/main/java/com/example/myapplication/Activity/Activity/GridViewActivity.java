package com.example.myapplication.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends AppCompatActivity {
    GridView mgrd;
    int[] imageIds = new int[]{R.mipmap.bomb0, R.mipmap.bomb1, R.mipmap.bomb2, R.mipmap.bomb3, R.mipmap.bomb4, R.mipmap.bomb5
            , R.mipmap.bomb6, R.mipmap.bomb7, R.mipmap.bomb8, R.mipmap.bomb9, R.mipmap.bomb10, R.mipmap.bomb11};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mgrd = (GridView) findViewById(R.id.grid_view);
        int[] to = new int[]{R.id.m_gridimage};//放谁的Id？？？？？
        String[] from = {"image"};
        List<Map<String, Object>> listItems = getAllData(); // 创建一个List对象，List对象的元素是Map
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.grialv_view, from, to);// 创建一个SimpleAdapter
        mgrd.setAdapter(adapter); //为GridView设置Adapter
        mgrd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "click" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<Map<String, Object>> getAllData() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        return listItems;
    }
}
