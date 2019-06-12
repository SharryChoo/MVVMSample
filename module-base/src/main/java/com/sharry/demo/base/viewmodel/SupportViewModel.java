package com.sharry.demo.base.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.sharry.demo.base.Preconditions;
import com.sharry.demo.base.livedata.SingleLiveData;
import com.sharry.demo.base.observer.TipObserver;
import com.sharry.demo.base.observer.ToastObserver;
import com.sharry.demo.base.observer.ViewStatusObserver;
import com.sharry.demo.base.view.SupportView;
import com.sharry.demo.base.view.SupportViewStatus;

/**
 * The support view model helper u build mvvm fast
 *
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 1.0
 * @since 2019-05-16 13:18
 */
public abstract class SupportViewModel extends AndroidViewModel {

    /**
     * The viewStatusSource associated with the special view that using this ViewModel.
     */
    protected final SingleLiveData<SupportViewStatus> viewStatusSource = new SingleLiveData<>();

    /**
     * The tip message associated with the special view that using this ViewModel.
     */
    protected final SingleLiveData<String> tipMsgSource = new SingleLiveData<>();

    /**
     * The toast message associated with the special view that using this ViewModel.
     */
    protected final SingleLiveData<String> toastMsgSource = new SingleLiveData<>();

    public SupportViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * The method invoke when first network error and u click retry.
     */
    protected void onNetworkRetry() {

    }

    /**
     * Set a observer for viewStatusSource.
     */
    public void setViewStatusObserve(@NonNull LifecycleOwner owner,
                                     @NonNull ViewStatusObserver viewStatusObserver) {
        Preconditions.checkNotNull(owner);
        Preconditions.checkNotNull(viewStatusObserver);
        viewStatusSource.observe(owner, viewStatusObserver);
        // The observer {@link Observer#onChanged} invoke when user click network retry.
        viewStatusObserver.setNetworkRetryObserver(owner, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isRetry) {
                if (isRetry) {
                    onNetworkRetry();
                }
            }
        });
    }

    /**
     * Set a observer for tipMsgSource.
     */
    public void setTipMsgSourceObserver(@NonNull LifecycleOwner owner,
                                        @NonNull TipObserver tipObserver) {
        Preconditions.checkNotNull(owner);
        Preconditions.checkNotNull(tipObserver);
        tipMsgSource.observe(owner, tipObserver);
    }

    /**
     * Set a observer for toastMsgSource.
     */
    public void setToastMsgSourceObserver(@NonNull LifecycleOwner owner,
                                          @NonNull ToastObserver toastObserver) {
        Preconditions.checkNotNull(owner);
        Preconditions.checkNotNull(toastObserver);
        toastMsgSource.observe(owner, toastObserver);
    }

}
