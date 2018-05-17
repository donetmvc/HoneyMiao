package com.donetmvc.honey.miao.core.net.netComponent

import com.donetmvc.honey.miao.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by liuwenbin on 18/3/10.
 */
object OkHttpCreator {

    fun create(): OkHttpClient {
        val client = OkHttpClient.Builder()
                //.cache(Cache(File(App.applicationContext().cacheDir.absoluteFile, "HttpCache"), (10 * 1024 * 1024).toLong()))
                .connectTimeout(15000, TimeUnit.MILLISECONDS)
                .readTimeout(15000, TimeUnit.MILLISECONDS)
                .writeTimeout(15000, TimeUnit.MILLISECONDS)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                }).build()

        return client
    }

    fun getInstance() = Holder.instance

    private object Holder {
        val instance = OkHttpCreator
    }
}