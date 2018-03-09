package com.donetmvc.honey.miao.core.net

/**
 * Created by liuwenbin on 18/3/10.
 */
class RequestManager {

    companion object {
        val INSTANCE = Holder.getInstance()
    }

    private object Holder {
        fun getInstance() = RequestManager()
    }
}