package com.inbergmarcano.mycvapp.base

import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformationDataManager

class BaseFragmentContract {

    interface Presenter<in T, in K> {
        fun subscribe(view: T, dataManager: K)
        fun unsubscribe()
    }

    interface View {}
}