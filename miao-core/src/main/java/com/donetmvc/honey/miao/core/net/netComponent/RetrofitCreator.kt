package com.donetmvc.honey.miao.core.net.netComponent

import retrofit2.Retrofit

/**
 * Created by liuwenbin on 18/3/10.
 */
object RetrofitCreator {

    private fun create(): Retrofit {
        val retrofit = Retrofit.Builder()
                .client(OkHttpCreator.getInstance().create())
                .build()

        return retrofit
    }

    fun getInstance() = Holder.instance.create()

    private object Holder {
        val instance = RetrofitCreator
    }
}