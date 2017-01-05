package com.example.myapplication.dao;

import android.content.Context;

import com.example.myapplication.R;
import com.example.myapplication.bean.Press;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/23.
 */

public class PressesBusiness {
    public ArrayList<Press> getPress(Context context) {
        ArrayList<Press> presses = new ArrayList<Press>();
        for (int i = 0; i < 10; i++) {
            Press p = new Press();
            p.icon = context.getResources().getDrawable(R.mipmap.mdtu);
            p.title = "习近平：重用改革促进派";
            p.content = "习近平要求推出立得住，群众认可硬招实招，提出群众幸福感。";
            p.comment = "1000评";
            presses.add(p);
        }
        return presses;
    }
}
