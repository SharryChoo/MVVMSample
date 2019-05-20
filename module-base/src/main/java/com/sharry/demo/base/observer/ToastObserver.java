package com.sharry.demo.base.observer;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.sharry.demo.base.view.SupportView;

/**
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 1.0
 * @since 2019-05-16 17:40
 */
public class ToastObserver implements Observer<String> {

    public static ToastObserver create(@NonNull SupportView view) {
        return new ToastObserver(view);
    }

    private final SupportView mView;

    private ToastObserver(SupportView view) {
        this.mView = view;
    }

    @Override
    public void onChanged(String msg) {
        mView.toast(msg);
    }

}
