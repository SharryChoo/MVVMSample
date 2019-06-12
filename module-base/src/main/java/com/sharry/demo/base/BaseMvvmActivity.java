package com.sharry.demo.base;

import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sharry.demo.base.observer.TipObserver;
import com.sharry.demo.base.observer.ToastObserver;
import com.sharry.demo.base.observer.ViewStatusObserver;
import com.sharry.demo.base.view.SupportView;
import com.sharry.demo.base.viewmodel.SupportViewModel;

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


    /**
     * Do common subscribe
     */
    protected <ViewModel extends SupportViewModel> void subscribeViewSource(@NonNull ViewModel viewModel) {
        // Set observer that view status source.
        viewModel.setViewStatusObserve(this, ViewStatusObserver.create(this, this));
        // Set observer that view tip msg source.
        viewModel.setTipMsgSourceObserver(this, TipObserver.create(this));
        // Set observer that view toast msg source.
        viewModel.setToastMsgSourceObserver(this, ToastObserver.create(this));
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