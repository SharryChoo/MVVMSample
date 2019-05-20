package com.sharry.demo.base.model;

import com.sharry.demo.base.model.local.LocalDataSource;
import com.sharry.demo.base.model.remote.RemoteDataSource;

/**
 * @author Sharry <a href="xiaoyu.zhu@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2019-05-20 16:28
 */
public interface DataSource extends LocalDataSource, RemoteDataSource {

    DataSource INSTANCE = new DataSourceRepository();

}
