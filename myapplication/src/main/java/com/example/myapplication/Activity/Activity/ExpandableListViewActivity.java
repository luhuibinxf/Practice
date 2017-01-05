package com.example.myapplication.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.myapplication.Activity.dao.MyExpandableListAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandableListViewActivity extends AppCompatActivity {
    private ExpandableListView expeadlist;//声明一个可伸展的列表视图对象
    private List<Map<String, Object>> groupList = new ArrayList<Map<String, Object>>();//声明并初始化一个组集合对象，该集合是一个一维数组
    private List<List<Map<String, Object>>> childList = new ArrayList<List<Map<String, Object>>>();//声明一个子元素集合对象，该集合是一个数组链表
    private List<Map<String, Object>> child;//声明一个子元素集合对象
    private Map<String, Object> map;//声明一个map对象
    private String[] armTypes = new String[]{"WORD", "EXCEL", "EMAIL", "PPT"};//组元素值
//    private String[]  child=new String[]{"夏雨","王睿"," 黄海波"," 刘冠翔","含笑","王斑","罗中旭","薛之谦 ","沙溢"," 李连杰"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);//加载布局
        for (int i = 0; i < armTypes.length; i++) { //给组赋值
            map = new HashMap<String, Object>();//每次都要初始化map对象
            map.put("Group", armTypes[i]);//将组值放入key为Group的map中
            groupList.add(map);//将map添加到组集合中
        }
        for (int j = 0; j < 4; j++) {//?4可以改为？？、//给每组的子元素赋值
            child = new ArrayList<Map<String, Object>>();//每次初始化子集合对象。该对象是一个一维数组
            for (int i = 0; i < 25; i++) {//每个组下面有25个子元素
                map = new HashMap<String, Object>();//初始化map对象
                map.put("Child", "我有" + i + "个苹果");//将子元素的值放入key值为Child的map中
                child.add(map);//将map添加到一维数组中
            }
            childList.add(child); //将一维数组添加到集合中
        }
        expeadlist = (ExpandableListView) findViewById(R.id.expandlst);//可伸展的列表视图绑定ID
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(ExpandableListViewActivity.this, groupList, childList);//声明并初始化一个adapter
        expeadlist.setAdapter(adapter);//可伸展的列表视图加载adapter
    }
}
