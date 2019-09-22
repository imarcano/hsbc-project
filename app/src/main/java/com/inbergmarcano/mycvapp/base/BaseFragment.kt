package com.inbergmarcano.mycvapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.di.component.DaggerApplicationComponent

abstract class BaseFragment: Fragment() {

    private lateinit var mBaseActivity: BaseActivity

    abstract fun getLayoutView(): Int


    abstract fun injectDependencies(applicationComponent: ApplicationComponent)

    abstract fun onViewReady(inflater: LayoutInflater, container : ViewGroup?, savedInstanceState: Bundle?, view: View)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mBaseActivity =  getContext() as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(getLayoutView(),container,false)
        injectDependencies(BaseApp.instance.getApplicationComponent())
        onViewReady(inflater, container, savedInstanceState, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBaseActivity =  context as BaseActivity
    }

    protected fun showProgressBar(){
        mBaseActivity.showProgressBar()
    }

    protected fun dismissProgressBar(){
        mBaseActivity.dismissProgressBar()
    }

    protected fun pushFragment(fragment: Fragment, vararg animations: Int){
        mBaseActivity.pushFragment(fragment, *animations)
    }


}