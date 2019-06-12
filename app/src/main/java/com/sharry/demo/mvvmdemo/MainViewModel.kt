package com.sharry.demo.mvvmdemo

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.databinding.ObservableArrayList
import com.sharry.demo.base.livedata.SingleLiveData
import com.sharry.demo.base.viewmodel.SupportViewModel

/**
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 1.0
 * @since 2019-05-20 16:34
 */
class MainViewModel(application: Application) : SupportViewModel(application) {

    val dataSetHolder = ObservableArrayList<String>()
    val isScrollToBottom = SingleLiveData<Boolean>()

    fun start() {
        toastMsgSource.value = "模拟网络请求开始"
        Handler().postDelayed({
            toastMsgSource.value = "模拟网络请求结束"
            for (i in 0..10) {
                dataSetHolder.add("Item position is ${i}")
            }
        }, 3000)
    }

    fun addItem() {
        dataSetHolder.add("This is new added Item.")
        Handler(Looper.getMainLooper()).postDelayed({
            isScrollToBottom.value = true
        }, 100)
    }

}