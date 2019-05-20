package com.sharry.demo.mvvmdemo

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sharry.demo.base.BaseMvvmActivity
import com.sharry.demo.mvvmdemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvvmActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initDataBinding(dataBinding: ActivityMainBinding) {
        // DataBinding 绑定 ViewModel
        dataBinding.view = this
        // DataBinding 绑定 ViewModel
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        dataBinding.viewmodel = viewModel
        // 初始化 ViewModel 通用的弹窗/toast ....
        viewModel.init(this, this)
        // 监听 ViewModel 中滚动到底部的事件
        viewModel.isScrollToBottom.observe(this, Observer<Boolean> {
            if (it) {
                lvItems.smoothScrollToPosition(lvItems.adapter.count)
            }
        })
    }

    override fun initData() {
        dataBinding.viewmodel?.start()
    }

}
