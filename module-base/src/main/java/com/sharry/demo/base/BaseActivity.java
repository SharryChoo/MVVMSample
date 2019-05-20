package com.sharry.demo.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity 的模板类
 *
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 2.0
 * @since 2018/8/27 22:00
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. Parse intent from other activity.
        Intent data = getIntent();
        if (null != data) {
            parseIntent(data);
        }
        // 2. Inject layout resource to content view.
        createView(getLayoutResId());
        // 3. Initialize view
        initTitle();
        initViews();
        // 4. Initialize data after view display on screen.
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        });
    }

    /**
     * U can parse intent that transfer from other activity.
     *
     * @param intent data that from request Activity.
     */
    protected void parseIntent(@NonNull Intent intent) {
    }

    /**
     * Get layout resource associated with this activity.
     *
     * @return layout id.
     */
    protected abstract int getLayoutResId();

    /**
     * Create view by u custom.
     */
    protected void createView(int layoutResId) {
        setContentView(layoutResId);
    }

    /**
     * Initialize title view associated with this activity.
     */
    protected void initTitle() {
    }

    /**
     * Initialize views associated with this activity.
     */
    protected void initViews() {
    }

    /**
     * Initialize data associated with this activity.
     */
    protected void initData() {
    }

}
