package com.sharry.demo.base.model;

/**
 * 数据源提供类
 *
 * @author Sharry <a href="xiaoyu.zhu@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2019-05-20 16:30
 */
class DataSourceRepository implements DataSource {

    @Override
    public String getMainText() {
        return "This is main activity";
    }
}
