package com.inbergmarcano.mycvapp.ui.basicinformation.presenter

import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationSuccessEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class BasicInformationPresenter:
    BasicInformationContract.Presenter {

    private lateinit var mView: BasicInformationContract.View
    private lateinit var mDataManager: BasicInformationContract.DataManager


    @Inject override fun subscribe(view: BasicInformationContract.View, dataManager: BasicInformationContract.DataManager) {
        EventBus.getDefault().register(this)
        mView = view
        mDataManager = dataManager
    }

    override fun unsubscribe() {
        EventBus.getDefault().unregister(this)
    }

    override fun loadData() {
        mDataManager.getResumeBasicInformation()
    }


    @Subscribe
    override fun onGetResumeBasicInformationSuccess(getBasicInformationSuccessEvent: GetBasicInformationSuccessEvent) {
        mView.loadDataSuccess(getBasicInformationSuccessEvent.basicInformations)

    }

    @Subscribe
    override fun onGetResumeBasicInformationFailure(getBasicInformationFailureEvent: GetBasicInformationFailureEvent) {
        mView.showErrorMessage(getBasicInformationFailureEvent.message)
    }
}