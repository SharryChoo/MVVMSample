package com.sharry.demo.base.view;

/**
 * Provider some status associated with view.
 *
 * @author Sharry <a href="xiaoyu.zhu@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2019-05-16 16:25
 */
public enum SupportViewStatus {
    /**
     * The status that normal.
     */
    NORMAL,

    /**
     * The status that do background task.
     */
    PROGRESS,

    /**
     * The status that network disconnected.
     */
    NO_NETWORK,

    /**
     * The status that data is empty.
     */
    EMPTY_DATA
}
