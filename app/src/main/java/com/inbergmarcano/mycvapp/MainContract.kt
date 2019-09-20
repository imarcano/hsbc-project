package com.inbergmarcano.mycvapp

import com.inbergmarcano.mycvapp.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun onDrawerOptionAboutClick()
    }
}