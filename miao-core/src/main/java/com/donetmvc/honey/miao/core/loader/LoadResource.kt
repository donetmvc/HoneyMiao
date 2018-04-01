package com.donetmvc.honey.miao.core.loader

import android.app.Activity
import android.content.res.AssetManager
import android.content.res.Resources

/**
 * Created by liuwenbin on 18/3/19.
 */
class LoadResource {

    /**
     * 从apk中加载资源
     * @param activity
     * @param dexPath path of dex/jar/apk file
     * */
     fun loadFromAsset(activity: Activity, dexPath: String) {

        var mAssetMamanger: AssetManager? = null

        try {
            val assetManager = AssetManager::class.java.newInstance()
            val method = assetManager.javaClass.getMethod("addAssetPath", String::class.java)

            method.invoke(assetManager, dexPath)

            mAssetMamanger = assetManager
        }
        catch (e: RuntimeException) {
            e.printStackTrace()
        }

        val resource = activity.resources
        @Suppress("DEPRECATION")
        val newResource = Resources(mAssetMamanger, resource.displayMetrics, resource.configuration)

        val theme = newResource.newTheme()
        theme.setTo(activity.theme)
    }

}