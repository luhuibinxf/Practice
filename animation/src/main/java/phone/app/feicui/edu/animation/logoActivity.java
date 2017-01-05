package phone.app.feicui.edu.animation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class logoActivity extends AppCompatActivity {
    private ImageView mImvLog, mImgApha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        mImgApha = (ImageView) findViewById(R.id.logo);
        mImvLog = (ImageView) findViewById(R.id.logo);
//        mImvLog.setBackgroundResource(R.drawable.logo);
//        AnimationDrawable atd = (AnimationDrawable) mImvLog.getBackground();
//        atd.start();
        mImvLog.setImageResource(R.drawable.logo);//帧动画
        AnimationDrawable animDraw = (AnimationDrawable) mImvLog.getDrawable();
        animDraw.start();

        Animation anim = new AlphaAnimation(0, 1);
        anim.setDuration(5000);
        anim.setRepeatCount(2);
        mImgApha.startAnimation(anim);//监听
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Intent intent = new Intent(logoActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //加载一些事件
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(logoActivity.this, AnimationActivity.class);
//                startActivity(intent);
//            }
//        });
//        thread.start();
    }
}
