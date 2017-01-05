package phone.app.feicui.edu.sms.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import phone.app.feicui.edu.sms.Dao.SaveInstance;
import phone.app.feicui.edu.sms.R;

public class PreservationActivity extends AppCompatActivity {
    Context mct;
    CheckBox mCB;

    /*
    *
    * 注意单例中的方法，以及上下文
    *
    *
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preservation);
        mCB = (CheckBox) findViewById(R.id.m_check);
        mct = this;
        mCB.setChecked(SaveInstance.getSaveInstance(mct).getBooleanValue("isSaved"));//少这一句会出现？？？？、
        mCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//注意监听这个方法的方法名
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SaveInstance.getSaveInstance(mct).putBoolean("isSaved", true);
                } else {
//                    SaveInstance.getSaveInstance(mct).putBoolean("isChecked", false);
                    SaveInstance.getSaveInstance(mct).putBoolean("isSaved", false);
                }
            }
        });
    }
}
