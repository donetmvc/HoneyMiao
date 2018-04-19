package com.donetmvc.honey.miao.core.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.donetmvc.honey.miao.core.R
import com.donetmvc.honey.miao.core.fragments.BaseFragment
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportActivity
import me.yokeyword.fragmentation.SupportActivityDelegate
import me.yokeyword.fragmentation.anim.FragmentAnimator

/**
 * Created by liuwenbin on 18/3/24.
 */
abstract class ProxyActivity: AppCompatActivity() , ISupportActivity {

    private val supportActivity = SupportActivityDelegate(this)

    abstract fun setRootFragment(): BaseFragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActivity.onCreate(savedInstanceState)
        initProxyActivity(savedInstanceState)
    }

    private fun initProxyActivity(savedInstanceState: Bundle?) {
//        val container = ContentFrameLayout(this)
//        container.id = R.id.delegate_container
        setContentView(R.layout.activity_proxy)

        if (savedInstanceState == null) {
            supportActivity.loadRootFragment(R.id.fragment_content, setRootFragment())
        }
    }

    override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator?) {
        supportActivity.fragmentAnimator = fragmentAnimator
    }

    override fun getFragmentAnimator(): FragmentAnimator {

        return supportActivity.fragmentAnimator
    }

    override fun onBackPressedSupport() {
        supportActivity.onBackPressedSupport()
    }

    override fun extraTransaction(): ExtraTransaction {
        return supportActivity.extraTransaction()
    }

    override fun onCreateFragmentAnimator(): FragmentAnimator {
        return supportActivity.onCreateFragmentAnimator()
    }

    override fun getSupportDelegate(): SupportActivityDelegate {
        return supportActivity
    }
}