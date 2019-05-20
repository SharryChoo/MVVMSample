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
 * @author Sharry <a href="xiaoyu.zhu@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2019-05-16 13:18
 */
public abstract class SupportViewModel extends AndroidViewModel {

    /**
     * The status associated with the special view that using this ViewModel.
     */
    protected final SingleLiveData<SupportViewStatus> status;

    /**
     * The tip message associated with the special view that using this ViewModel.
     */
    protected final SingleLiveData<String> tipMsg;

    /**
     * The toast message associated with the special view that using this ViewModel.
     */
    protected final SingleLiveData<String> toastMsg;

    /**
     * The observer {@link Observer#onChanged} invoke when user click network retry.
     */
    private final Observer<Boolean> mNetworkRetryObserver = new Observer<Boolean>() {
        @Override
        public void onChanged(Boolean isRetry) {
            if (isRetry) {
                networkRetry();
            }
        }
    };

    public SupportViewModel(@NonNull Application application) {
        super(application);
        this.status = new SingleLiveData<>();
        this.tipMsg = new SingleLiveData<>();
        this.toastMsg = new SingleLiveData<>();
    }

    /**
     * Init this ViewModel, U need invoke sequence after ViewModel constructor.
     */
    public <View extends SupportView> void init(@NonNull LifecycleOwner owner, @NonNull View view) {
        Preconditions.checkNotNull(owner);
        Preconditions.checkNotNull(view);
        this.status.observe(owner, ViewStatusObserver.create(view, owner, mNetworkRetryObserver));
        this.tipMsg.observe(owner, TipObserver.create(view));
        this.toastMsg.observe(owner, ToastObserver.create(view));
    }

    /**
     * The method invoke when first network error and u click retry.
     */
    protected void networkRetry() {

    }

}
