package com.donetmvc.honey.miao.business.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.donetmvc.honey.miao.business.R
import com.donetmvc.honey.miao.business.SetFragment
import com.donetmvc.honey.miao.core.fragments.BaseFragment
import com.donetmvc.honey.miao.core.fragments.PermissionFragment

class HomeFragment: PermissionFragment() {

    private lateinit var btn_go_detail: Button
    private lateinit var btn_go_set: Button

    override fun setContentFragment(): Any {
        return R.layout.fragment_content
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {
        btn_go_detail = rootView.findViewById(R.id.btn_go_detail)
        btn_go_set = rootView.findViewById(R.id.btn_go_set)

        btn_go_detail.setOnClickListener {
            supportDelegate.start(DetailFragment())
        }

        btn_go_set.setOnClickListener {
            supportDelegate.start(SetFragment())
        }
    }
}