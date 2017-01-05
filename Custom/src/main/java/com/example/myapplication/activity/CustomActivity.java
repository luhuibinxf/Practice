package com.example.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Proudects;
import com.example.myapplication.dao.ProductsBusiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Context mctc;
    private ListView mcustomLV;
    private ArrayList<Proudects> mproducts;
    private ProductsBusiness pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mctc = this;
        setContentView(R.layout.activity_custom);
        mcustomLV = (ListView) findViewById(R.id.listView);//1.根据ID找控件
        pb = new ProductsBusiness();//2.获取数据用list封装
        mproducts = pb.getProudect(mctc);
        mcustomLV.setAdapter((new CustomAdater()));//3.将适配器给listView控件
        //p.Url（作用）
        mcustomLV.setOnItemClickListener(this);//4.设置listview条目的点击事件(例如链接)
    }

    /**
     * //用户点击某一项，回传些事件，我们重写些方法做相应处理
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Proudects p = (Proudects) parent.getItemAtPosition(position);
        /**
         * 点击事件的设置
         */
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("" + pb.getProudect(mctc).get(position).uri));//这样写？？？？
        mctc.startActivity(intent);
    }

    class CustomAdater extends BaseAdapter {
        Map<Integer, String> map = new HashMap<Integer, String>();//Integer整数

        @Override
        public int getCount() {// 数据数量
            return mproducts.size();//作用
        }

        @Override
        public Object getItem(int position) {//根据下标获取对应数据  position：对应下标
            return mproducts.get(position);
        }

        @Override
        public long getItemId(int position) {//根据下标获取对应数据ID  position
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//生成数据对应布局	position
            View v = convertView; //1.复用view优化listview,创建一个view作为getview的返回值用来显示一个条目
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) mctc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(R.layout.activity_cm_lv, null);//?????
            }
            ImageView proIcon = (ImageView) v.findViewById(R.id.mjpg_1);//2.获取view上的子控件对象
            TextView proTitle = (TextView) v.findViewById(R.id.m_Title);
            TextView proContent = (TextView) v.findViewById(R.id.m_content);
            TextView proPrice = (TextView) v.findViewById(R.id.m_price);
            TextView proNumber = (TextView) v.findViewById(R.id.m_sales);
            Proudects proudects = mproducts.get(position); //3.获取postion位置条目对应的list集合中的数据，Bean对象
            proIcon.setBackground(pb.getProudect(mctc).get(position).icon); //4.将数据设置给这些子控件做显示
            proTitle.setText(pb.getProudect(mctc).get(position).title);
            proContent.setText(pb.getProudect(mctc).get(position).content);
            proPrice.setText(pb.getProudect(mctc).get(position).price);
            proNumber.setText(pb.getProudect(mctc).get(position).number);
            return v;
        }
    }
}
