package com.sharry.demo.base.observer;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.sharry.demo.base.Preconditions;
import com.sharry.demo.base.livedata.SingleLiveData;
import com.sharry.demo.base.view.SupportView;
import com.sharry.demo.base.view.SupportViewStatus;

/**
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 1.0
 * @since 2019-05-16 17:19
 */
public class ViewStatusObserver implements Observer<SupportViewStatus> {

    /**
     * Create an instance of View Status.
     *
     * @param view  the support view.
     * @param owner lifecycle owner.
     */
    public static ViewStatusObserver create(@NonNull SupportView view,
                                            @NonNull LifecycleOwner owner) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(owner);
        return new ViewStatusObserver(view, owner);
    }

    private final SupportView mView;
    private final SingleLiveData<Boolean> mNetworkRetryObservable;

    private ViewStatusObserver(SupportView view, LifecycleOwner owner) {
        this.mView = view;
        this.mNetworkRetryObservable = new SingleLiveData<>();
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

    public void setNetworkRetryObserver(LifecycleOwner owner, Observer observer) {
        mNetworkRetryObservable.observe(owner, observer);
    }

}
