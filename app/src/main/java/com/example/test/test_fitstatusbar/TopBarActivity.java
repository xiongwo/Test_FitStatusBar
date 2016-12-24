package com.example.test.test_fitstatusbar;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by liuyuhua on 2016/12/17.
 */

public class TopBarActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_top_bar);
        setStatusBar();
    }

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.top_bar);
            System.out.println("viewGroup的LayoutParams: " + viewGroup.getLayoutParams());

            final int statusHeight = getStatusHeight();
            viewGroup.post(new Runnable() {
                @Override
                public void run() {
                    int topBarHeight = viewGroup.getHeight();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.height = statusHeight + topBarHeight;
                    viewGroup.setLayoutParams(layoutParams);
                }
            });
        }
    }
}
