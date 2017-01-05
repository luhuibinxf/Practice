package phone.app.feicui.edu.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImgScale, mImgApha, mImgRoate, mImgTrans, mImgset;
    Button mBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mBut = (Button) findViewById(R.id.m_set);
        mBut.setOnClickListener(this);
        mBut = (Button) findViewById(R.id.m_frame);
        mBut.setOnClickListener(this);
//        mImgScale = (ImageView) findViewById(R.id.m_img_scale);
//        mImgApha = (ImageView) findViewById(R.id.m_img_alpha);
//        mImgRoate = (ImageView) findViewById(R.id.m_img_rotate);
//        mImgTrans = (ImageView) findViewById(R.id.m_img_translate);
        mImgset = (ImageView) findViewById(R.id.m_img_set);
//        Animation anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.scale);
//        mImgScale.startAnimation(anim);
//        anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.alpha);
//        mImgApha.startAnimation(anim);
//        anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.rotate);
//        mImgRoate.startAnimation(anim);
//        anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.translate);
//        mImgTrans.startAnimation(anim);
        Animation anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.set);
        mImgset.startAnimation(anim);

//        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f,1f,0.5f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        scaleAnimation.setRepeatCount(Animation.INFINITE);
//        scaleAnimation.setRepeatMode(Animation.RESTART);
//        scaleAnimation.setFillAfter(true);
//        scaleAnimation.setDuration(5000);
//        mImgScale.startAnimation(scaleAnimation);
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
//        alphaAnimation.setRepeatCount(Animation.INFINITE);
//        alphaAnimation.setFillAfter(true);
//        alphaAnimation.setDuration(5000);
//        mImgApha.startAnimation(alphaAnimation);
//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 10, 0, 10);
//        translateAnimation.setDuration(1000);
//        translateAnimation.setRepeatCount(Animation.INFINITE);
//        translateAnimation.setFillAfter(true);
//        mImgTrans.startAnimation(translateAnimation);
//        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, 25, 25);
//        rotateAnimation.setDuration(1000);
//        rotateAnimation.setRepeatCount(Animation.INFINITE);
//        rotateAnimation.setFillAfter(false);
//        mImgRoate.startAnimation(rotateAnimation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.m_set:
                Intent intent = new Intent(AnimationActivity.this, SetActivity.class);
                startActivity(intent);
                break;
            case R.id.m_frame:
                intent = new Intent(AnimationActivity.this, Frame.class);
                startActivity(intent);
                break;
        }
    }
}
