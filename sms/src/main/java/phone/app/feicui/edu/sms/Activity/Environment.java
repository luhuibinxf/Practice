package phone.app.feicui.edu.sms.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import phone.app.feicui.edu.sms.R;
import phone.app.feicui.edu.sms.Util.EnvironmentUtil;

public class Environment extends AppCompatActivity {
    TextView mTV;
    Button mBt;
    EnvironmentUtil eu;

    /**
     * 记着给权限，还有应用中的权限开了没有
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);
        mTV = (TextView) findViewById(R.id.TextView);
        eu = new EnvironmentUtil();
        mBt = (Button) findViewById(R.id.wirte1);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eu.writeFileExteranlStorage();
            }
        });
        mBt = (Button) findViewById(R.id.read1);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTV.setText(eu.readFileFromExteranlStorage());
            }
        });
    }
}
