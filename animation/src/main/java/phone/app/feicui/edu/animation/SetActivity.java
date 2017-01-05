package phone.app.feicui.edu.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class SetActivity extends AppCompatActivity {
    private ImageView mImgset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        mImgset = (ImageView) findViewById(R.id.m_img_set);
//        Animation anim = AnimationUtils.loadAnimation(SetActivity.this, R.anim.set);
//        mImgset.startAnimation(anim);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f, Animation.RELATIVE_TO_SELF, Animation.RELATIVE_TO_SELF);//放缩
        scaleAnimation.setDuration(5000);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);//显影
        alphaAnimation.setDuration(5000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 120, 25, 25);//旋转
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 10, 0, 10);//位移
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        set.addAnimation(rotateAnimation);
        set.addAnimation(translateAnimation);
        mImgset.startAnimation(set);
    }
}
