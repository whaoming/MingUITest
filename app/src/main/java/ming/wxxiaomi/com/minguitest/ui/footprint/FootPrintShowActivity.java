package ming.wxxiaomi.com.minguitest.ui.footprint;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ming.wxxiaomi.com.minguitest.R;

public class FootPrintShowActivity extends AppCompatActivity {
    private Button btn;
    private LinearLayout demo1;
    private LinearLayout demo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_print_show);
        demo1 = (LinearLayout) findViewById(R.id.demo1);
        btn = (Button) findViewById(R.id.btn);
        demo2 = (LinearLayout) findViewById(R.id.demo2);
//        final Animation scaleAnimation2= new ScaleAnimation(1, 1.0f, 1f, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
//                0f);

        final Animation scaleAnimation= new ScaleAnimation(1, 1.0f, 1f, 0.5f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                0f);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i("wang","onAnimationStart");

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("wang","onAnimationEnd");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i("wang","onAnimationRepeat");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("wang","onClick");
//                RelativeLayout.LayoutParams Params =  (RelativeLayout.LayoutParams)demo1.getLayoutParams();
//                Params.height = 500;
//                demo1.setLayoutParams
// (Params);

                scaleAnimation.setDuration(2000);               //动画持续时间
                demo1.setAnimation(scaleAnimation);         //设置动画
                scaleAnimation.startNow();
                RelativeLayout.LayoutParams Params =  (RelativeLayout.LayoutParams)demo1.getLayoutParams();
                Params.height = 500;
                demo1.setLayoutParams(Params);


            }
        });
    }
}
