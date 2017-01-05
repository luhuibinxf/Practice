package com.example.myapplication.dao;


import android.content.Context;
import android.net.Uri;

import com.example.myapplication.R;
import com.example.myapplication.bean.Proudects;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/23.
 */

public class ProductsBusiness {
    public ArrayList<Proudects> getProudect(Context context) {
        ArrayList<Proudects> proudectses = new ArrayList<Proudects>();
        for (int i = 0; i < 5; i++) {
            Proudects p = new Proudects();
            p.icon = context.getResources().getDrawable(R.mipmap.mjpg);
            p.title = "韩国高端婚纱摄影";
            p.content = "造型写真，（证件照。。。。）造型写真，（证件照。。。。）";
            p.number = "已售出100";
            p.price = "单价￥10.0";
            p.uri = Uri.parse("http://www.baidu.com");//需注意写法
            proudectses.add(p);
        }
        return proudectses;
    }
}
