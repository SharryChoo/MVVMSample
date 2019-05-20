package com.sharry.demo.base;

import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sharry.demo.base.view.SupportView;

/**
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 1.0
 * @since 2019-05-20 16:21
 */
public abstract class BaseMvvmActivity<DataBinding extends ViewDataBinding> extends BaseActivity
        implements SupportView<DataBinding> {

    protected DataBinding dataBinding;

    @Override
    protected void createView(int layoutResId) {
        dataBinding = DataBindingUtil.setContentView(this, layoutResId);
        if (dataBinding == null) {
            throw new NullPointerException("Cannot find ViewDataBinding that layout id is: " + layoutResId);
        }
        initDataBinding(dataBinding);
    }

    @Override
    public void tip(@Nullable String msg) {
        // TODO: Custom u simple tip display.
    }

    @Override
    public void toast(@Nullable String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void snackBar(@Nullable String msg) {
        // TODO: Custom u snackbar display.
    }

    @Override
    public void progress(boolean isShow) {
        progress(findViewById(android.R.id.content), isShow);
    }

    @Override
    public void progress(@NonNull View attached, boolean isShow) {
        // TODO: Custom u progress display.
    }

    @Override
    public void showEmptyData() {
        showEmptyData(findViewById(android.R.id.content));
    }

    @Override
    public void showEmptyData(@NonNull View attached) {
        // TODO: Custom u empty data display.
    }

    @Override
    public void showNetworkError(SupportView.OnNetworkErrorListener listener) {
        showNetworkError(findViewById(android.R.id.content), listener);
    }

    @Override
    public void showNetworkError(@NonNull View attached, final SupportView.OnNetworkErrorListener listener) {
        // TODO: Custom u network error display.
    }

}