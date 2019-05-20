package com.sharry.demo.base.view;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

/**
 * The View provider more function.
 *
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 1.0
 * @since 2018/8/28 22:21
 */
public interface SupportView<T extends ViewDataBinding> extends BaseView<T> {

    /**
     * Show simple tips.
     */
    void tip(@Nullable String msg);

    /**
     * Show toast.
     */
    void toast(@Nullable String msg);

    /**
     * Show snack bar.
     */
    void snackBar(@Nullable String msg);

    /* ============================== Progress Bar =======================================*/

    /**
     * Show progress view associated with current page
     * Use default attach view {@code R.android.id.cåontent}.
     */
    void progress(boolean isShow);

    /**
     * Show progress view associated with current page.
     */
    void progress(@NonNull View attached, boolean isShow);

    /* ============================== Empty data =======================================*/

    /**
     * Show empty data without msg associated with current page.
     * Use default attach view {@code R.android.id.content}.
     */
    void showEmptyData();

    /**
     * Show empty data without msg associated with current page.
     */
    void showEmptyData(@NonNull View attached);

    /* ============================== Network Error =======================================*/

    /**
     * Show network disconnected associated with current page.
     * Use default attach view {@code R.android.id.content}.
     */
    void showNetworkError(OnNetworkErrorListener listener);

    /**
     * Show network disconnected associated with current page.
     */
    void showNetworkError(@NonNull View attached, OnNetworkErrorListener listener);

    /**
     * Callback associated with disconnected view.
     */
    interface OnNetworkErrorListener {
        void onNetworkError();
    }

}
