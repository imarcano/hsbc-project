package com.inbergmarcano.mycvapp.base

class BaseContract {

    interface Presenter<in T, in K> {
        fun subscribe(view: T, dataManager: K)
        fun unsubscribe()
    }

    interface View {}
}