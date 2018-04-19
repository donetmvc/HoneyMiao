package com.donetmvc.honey.miao.business

import android.os.Bundle
import android.view.View
import com.donetmvc.honey.miao.core.fragments.BaseFragment

class SetFragment: BaseFragment() {

    override fun setContentFragment(): Any {
        return R.layout.fragment_set
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {
    }

}