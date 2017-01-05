package phone.app.feicui.edu.sms.Activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import phone.app.feicui.edu.sms.Bean.SmsBean;
import phone.app.feicui.edu.sms.Dao.SmsDao;
import phone.app.feicui.edu.sms.R;

public class SmsActivity extends AppCompatActivity {
    Context mCtx;
    Button mBut;
    SmsDao sd;
    ArrayList<SmsBean> arrayList;
    ListView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = this;
        setContentView(R.layout.activity_sms);
        mLv = (ListView) findViewById(R.id.m_listview);
        sd = new SmsDao(mCtx);
        arrayList = sd.readList();
        mBut = (Button) findViewById(R.id.read);
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLv.setAdapter(new CustomAdater());
            }
        });
        mBut = (Button) findViewById(R.id.wirte);
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sd.writeToXml();
            }
        });
    }

    class CustomAdater extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            View v = null;
//            if (convertView != null) {
//                v = convertView;
//            } else {
//                LayoutInflater layoutInflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                v = layoutInflater.inflate(R.layout.sms_lv, null);
//            }
            /**
             * 上面的写法
             */
            View v = convertView;
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(R.layout.sms_lv, null);
            }
            TextView sNum = (TextView) v.findViewById(R.id.m_num);//少了v.会出现什么异常
            TextView sMgs = (TextView) v.findViewById(R.id.m_mgs);
            TextView sData = (TextView) v.findViewById(R.id.m_data);
            /**
             * 这样的写法
             */
            SmsBean sb = arrayList.get(position);
            sNum.setText(sb.num);
            sMgs.setText(sb.msg);
            sData.setText(sb.data);
            return v;//注意这个返回值
        }
    }
}
