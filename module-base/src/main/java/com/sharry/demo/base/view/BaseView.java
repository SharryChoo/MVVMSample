package com.sharry.demo.base.view;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

/**
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 1.0
 * @since 2018/8/29 23:27
 */
public interface BaseView<T extends ViewDataBinding> {

    /**
     * Do init operation when data binding created.
     *
     * @param dataBinding the data binding that need init.
     */
    void initDataBinding(@NonNull T dataBinding);

}
