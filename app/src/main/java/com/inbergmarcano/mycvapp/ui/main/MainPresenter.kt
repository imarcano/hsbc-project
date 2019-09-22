package com.inbergmarcano.mycvapp.ui.main

import com.inbergmarcano.mycvapp.rest.events.GetHeaderFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetHeaderSuccessEvent
import com.inbergmarcano.mycvapp.ui.main.model.HeaderDataManager
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class MainPresenter: MainContract.Presenter {

    private lateinit var view: MainContract.View
    private lateinit var dataManager: HeaderDataManager

    override fun subscribe(view: MainContract.View, dataManager: HeaderDataManager) {
        this.view = view
        this.dataManager = dataManager
        EventBus.getDefault().register(this)
    }

    override fun unsubscribe() {
        EventBus.getDefault().unregister(this)
    }

    override fun loadData() {
        dataManager.getResumeHeader()
    }

    @Subscribe
    override fun onGetResumeBasicInformationSuccess(getHeaderSuccessEvent: GetHeaderSuccessEvent) {
        view.customizeHeaderName(getHeaderSuccessEvent.data.name)
        view.customizeHeaderPicture(getHeaderSuccessEvent.data.picture)
        view.customizeHeaderEmail(getHeaderSuccessEvent.data.email)
    }

    @Subscribe
    override fun onGetResumeBasicInformationFailure(getHeaderFailureEvent: GetHeaderFailureEvent) {
        view.showErrorMessage(getHeaderFailureEvent.message)
    }
}