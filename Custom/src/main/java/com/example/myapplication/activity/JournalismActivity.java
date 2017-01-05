package com.example.myapplication.activity;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Press;
import com.example.myapplication.dao.PressesBusiness;

import java.util.ArrayList;

public class JournalismActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mjourLV;
    private Context mjux;
    private PressesBusiness mpb;
    private ArrayList<Press> mpresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mjux = this;//??????
        setContentView(R.layout.activity_journalism);
        mjourLV = (ListView) findViewById(R.id.listView);//找样式
        mpb = new PressesBusiness();
        mpresses = mpb.getPress(mjux);
        //自己重新写适配器（需注意）
        mjourLV.setAdapter(new CustomAdater()); //将适配器给listView控件
//        mjourLV.setOnItemClickListener(this);//设置listview条目的点击事件

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Press p = (Press) parent.getItemAtPosition(position);//为什么这样写？？？、
    }

    class CustomAdater extends BaseAdapter {

        @Override
        public int getCount() {//得到谁的大小
            return mpresses.size();
        }

        @Override
        public Object getItem(int position) {//获取项
            return mpresses.get(position);
        }

        @Override
        public long getItemId(int position) {//获取项的ID
            return position;
        }

        /**
         * if()中的注释以及其作用？？？？？
         * mjux:上下文, resource:要转换成view对象的layout的id, root:将layout用root(ViewGroup)包一层作为codify的返回,一般传null
         * 通过LayoutInflater将布局转换成view对象
         *
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//主要的方法
            View v = convertView;//这样写的好处 //1.复用view优化listview,创建一个view作为getview的返回值用来显示一个条目
            if (v == null) {
//                v = View.inflate(mjux, R.layout.activity_jl_lv, null);
                v = LayoutInflater.from(mjux).inflate(R.layout.activity_jl_lv, null);// 通过LayoutInflater将布局转换成view对象

            }
            ImageView preIcon = (ImageView) v.findViewById(R.id.mjp_2);//2.获取view上的子控件对象
            TextView preTitle = (TextView) v.findViewById(R.id.m_Title1);
            TextView preContent = (TextView) v.findViewById(R.id.m_content1);
            TextView preComment = (TextView) v.findViewById(R.id.m_comment);
            Press press = mpresses.get(position);//3.获取postion位置条目对应的list集合中的数据，Bean对象
            preIcon.setBackground(press.icon); //4.将数据设置给这些子控件做显示
            preTitle.setText(press.title);
            preContent.setText(press.content);
            preComment.setText(press.comment);
            return v;
//            TextView tv=(TextView) view;//????????作用
//            if (view==null){
//                tv = new TextView(mctx);
//            }
//                tv.setText("position#############:" + position);
//
//            map.put(tv.hashCode(),"");
//            LogUtils.i(TAG,""+map.size());
//            return tv;
        }
    }
}
