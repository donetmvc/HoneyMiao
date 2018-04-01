package com.donetmvc.honey.miao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.donetmvc.honey.miao.core.activity.ProxyActivity
import com.donetmvc.honey.miao.core.delegates.BaseFragmentDelegate

class MainActivity : ProxyActivity() {

    override fun setRootFragment(): BaseFragmentDelegate? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
    }


}
