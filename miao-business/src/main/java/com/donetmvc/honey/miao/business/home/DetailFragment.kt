package com.donetmvc.honey.miao.business.home

import android.os.Bundle
import android.view.View
import com.donetmvc.honey.miao.business.R
import com.donetmvc.honey.miao.core.fragments.BaseFragment

class DetailFragment: BaseFragment() {

    override fun setContentFragment(): Any {
        return R.layout.fragment_detail
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {

    }

}