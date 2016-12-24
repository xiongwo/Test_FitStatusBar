package com.example.test.test_fitstatusbar;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;

public class ToolBarActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

//        getToolBarHeight();
//        System.out.println("status bar : " + getStatusHeight());
//        System.out.println("action bar : " + getActionBarHeight());
    }

    protected void getToolBarHeight() {
        mToolbar.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("tool bar : " + mToolbar.getHeight());
                System.out.println("tool bar padding top: " + mToolbar.getPaddingTop());
            }
        });
    }

    protected int getActionBarHeight() {
        int actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }
}
