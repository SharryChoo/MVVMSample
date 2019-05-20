package com.sharry.demo.base.observer;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.sharry.demo.base.Preconditions;
import com.sharry.demo.base.livedata.SingleLiveData;
import com.sharry.demo.base.view.SupportView;
import com.sharry.demo.base.view.SupportViewStatus;

/**
 * @author Sharry <a href="xiaoyu.zhu@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2019-05-16 17:19
 */
public class ViewStatusObserver implements Observer<SupportViewStatus> {

    public static ViewStatusObserver create(@NonNull SupportView view,
                                            @NonNull LifecycleOwner owner,
                                            @NonNull Observer<Boolean> networkRetryObserver) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(owner);
        Preconditions.checkNotNull(networkRetryObserver);
        return new ViewStatusObserver(view, owner, networkRetryObserver);
    }

    private final SupportView mView;
    private final SingleLiveData<Boolean> mNetworkRetryObservable;

    private ViewStatusObserver(SupportView view, LifecycleOwner owner, Observer<Boolean> networkRetryObserver) {
        this.mView = view;
        this.mNetworkRetryObservable = new SingleLiveData<>();
        this.mNetworkRetryObservable.observe(owner, networkRetryObserver);
    }

    @Override
    public void onChanged(SupportViewStatus viewStatus) {
        switch (viewStatus) {
            case PROGRESS:
                mView.progress(true);
                break;
            case NORMAL:
                mView.progress(false);
                break;
            case EMPTY_DATA:
                mView.showEmptyData();
                mView.progress(false);
                break;
            case NO_NETWORK:
                mView.showNetworkError(new SupportView.OnNetworkErrorListener() {
                    @Override
                    public void onNetworkError() {
                        mNetworkRetryObservable.setValue(true);
                    }
                });
                mView.progress(false);
                break;
            default:
                break;
        }
    }

}
