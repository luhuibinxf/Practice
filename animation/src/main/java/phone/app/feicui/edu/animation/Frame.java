package phone.app.feicui.edu.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/12/27.
 */

public class Frame extends AppCompatActivity {
    private ImageView mt;
    private Button mBut;
    AnimationDrawable animationDrawable;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);
        mt = (ImageView) findViewById(R.id.m_frame);
        mt.setBackgroundResource(R.drawable.frames);
        mBut = (Button) findViewById(R.id.m_f_bt);
        animationDrawable = (AnimationDrawable) mt.getBackground();
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
            }
        });
        mBut = (Button) findViewById(R.id.m_f_bt1);
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });

    }

}
