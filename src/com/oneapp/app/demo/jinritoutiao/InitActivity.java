package com.oneapp.app.demo.jinritoutiao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.core.util.UiUtil;
import com.oneapp.app.demo.jinritoutiao.ui.activity.main.MainActivity;

public class InitActivity extends BaseActivity {
    private AlphaAnimation start_anima;
    private View rootView;
    @Override
    protected void init(Bundle savedInstanceState) {
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_init_layout;
    }

    private void initData() {
        rootView = UiUtil.getRootView(this);
        start_anima = new AlphaAnimation(0.3f, 1.0f);
        start_anima.setDuration(2000);
        rootView.startAnimation(start_anima);
        start_anima.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                redirectTo();
            }
        });
    }

    private void redirectTo() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
