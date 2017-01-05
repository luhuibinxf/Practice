package phone.app.feicui.edu.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class PropertyActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        iv = (ImageView) findViewById(R.id.m_property);
        /**
         * 使用Xml文件来设置属性动画
         */
        Animator oa = AnimatorInflater.loadAnimator(this, R.animator.set);//注意那些效果可以设置X与Y

        iv.invalidate();
        oa.setTarget(iv);//设置执行目标
        oa.start();
    }


//    public void translate(View v) {//位移动画
//        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationY", 10, 50, 20, 100);
//        oa.setDuration(2000);
//        oa.start(); //开始动画
//    }

    //    public void translate(View v) {//位移动画
//        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotationX", 10, 20, 10, 100);
//        oa.setDuration(2000);
//        oa.start();
//    }
//    public void translate(View v){//实现旋转的效果
//        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotationX", 0, 180, 90, 360);
//        oa.setDuration(2000);
//        oa.start();
//    }
//    public void translate(View v) {//缩放动画
//        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "scaleY", 0, 0.5f, 0, 1, 0, 1);
//        oa.setDuration(2000);
//        oa.start();
//    }
//    public void translate(View v) {//实现透明的效果
//        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "alpha", 0, 0.5f, 0, 1, 0, 1);
//        oa.setDuration(2000);
//        oa.start();
//    }
    public void translate(View v) {//一起出现
        AnimatorSet as = new AnimatorSet();//注意单词
        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotationX", 10, 20, 10, 100);
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(iv, "scaleY", 0.1f, 2, 1, 2);
        ObjectAnimator oa4 = ObjectAnimator.ofFloat(iv, "scaleX", 0.1f, 2, 1, 2);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv, "alpha", 0, 0.5f, 0, 1);
        ObjectAnimator oa3 = ObjectAnimator.ofFloat(iv, "rotationX", 0, 180, 90, 360);//切换不同的X与Y看效果
        as.setDuration(5000);//执行动画时长
        as.setTarget(iv);//iv执行动画
//        as.playSequentially(oa, oa1, oa2, oa3, oa4);//挨个飞
        as.playTogether(oa, oa1, oa2, oa3, oa4);//一起飞
        as.start();
    }
}
