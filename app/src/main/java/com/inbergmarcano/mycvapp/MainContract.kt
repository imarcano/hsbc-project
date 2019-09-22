package com.inbergmarcano.mycvapp

import com.inbergmarcano.mycvapp.base.BaseActivityContract
import com.inbergmarcano.mycvapp.base.BaseFragmentContract

class MainContract {

    interface View: BaseActivityContract.View {
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter: BaseActivityContract.Presenter<View> {
        fun onDrawerOptionAboutClick()
    }
}