package com.donetmvc.honey.miao.business

import android.os.Bundle
import android.view.View
import com.donetmvc.honey.miao.core.delegates.BaseFragmentDelegate

class SetFragment: BaseFragmentDelegate() {

    override fun setContentFragment(): Any {
        return R.layout.fragment_set
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {
    }

}