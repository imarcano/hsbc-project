package com.inbergmarcano.mycvapp.base

import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformationDataManager

class BaseActivityContract {

    interface Presenter<in T> {
        fun subscribe(view: T)
        fun unsubscribe()
    }

    interface View {}
}