package com.inbergmarcano.mycvapp

import io.reactivex.disposables.CompositeDisposable


class MainPresenter: MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View

    override fun subscribe(view: MainContract.View) {
        this.view = view
        view.showListFragment()
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun onDrawerOptionAboutClick() {
        view.showAboutFragment()
    }
}