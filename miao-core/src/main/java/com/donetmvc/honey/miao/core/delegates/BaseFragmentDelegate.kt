package com.donetmvc.honey.miao.core.delegates

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.SupportFragmentDelegate
import me.yokeyword.fragmentation.anim.FragmentAnimator


/**
 * Created by liuwenbin on 18/3/31.
 */
abstract class BaseFragmentDelegate: Fragment() , ISupportFragment {

    abstract fun setContentFragment(): Any

    abstract fun onBindView(savedInstanceState: Bundle?, rootView: View)

    private val supportFragment = SupportFragmentDelegate(this)

    override fun setFragmentResult(resultCode: Int, bundle: Bundle?) {
        supportFragment.setFragmentResult(resultCode, bundle)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        supportFragment.onAttach(context as Activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragment.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = when {
            setContentFragment() is Int -> inflater!!.inflate((setContentFragment() as Int), container, false)
            setContentFragment() is View -> setContentFragment() as View
            else -> throw ClassCastException("type of setContentLaoyout() must be int or View!")
        }

        onBindView(savedInstanceState, rootView)

        return rootView
    }

    override fun onSupportInvisible() {
        supportFragment.onSupportInvisible()
    }

    override fun onNewBundle(args: Bundle?) {
        supportFragment.onNewBundle(args)
    }

    override fun extraTransaction(): ExtraTransaction {
        return supportFragment.extraTransaction()
    }

    override fun onCreateFragmentAnimator(): FragmentAnimator {
        return supportFragment.onCreateFragmentAnimator()
    }

    override fun enqueueAction(runnable: Runnable?) {
        supportFragment.enqueueAction(runnable)
    }

    override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle?) {
        supportFragment.onFragmentResult(requestCode, resultCode, data)
    }

    override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator?) {
        supportFragment.fragmentAnimator = fragmentAnimator
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        supportFragment.onLazyInitView(savedInstanceState)
    }

    override fun getFragmentAnimator(): FragmentAnimator {
        return supportFragment.fragmentAnimator
    }

    override fun isSupportVisible(): Boolean {
        return supportFragment.isSupportVisible
    }

    override fun onEnterAnimationEnd(savedInstanceState: Bundle?) {
        supportFragment.onEnterAnimationEnd(savedInstanceState)
    }

    override fun onSupportVisible() {
        supportFragment.onSupportInvisible()
    }

    override fun onBackPressedSupport(): Boolean {
        return supportFragment.onBackPressedSupport()
    }

    override fun getSupportDelegate(): SupportFragmentDelegate {
        return supportFragment
    }

    override fun putNewBundle(newBundle: Bundle?) {

    }

}