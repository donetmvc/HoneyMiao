package com.donetmvc.honey.miao

import com.donetmvc.honey.miao.business.home.HomeFragment
import com.donetmvc.honey.miao.core.activity.ProxyActivity
import com.donetmvc.honey.miao.core.delegates.BaseFragmentDelegate

class MainActivity : ProxyActivity() {

    override fun setRootFragment(): BaseFragmentDelegate? {
        return HomeFragment()
    }

}
