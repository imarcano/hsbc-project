package com.inbergmarcano.mycvapp.ui.basicinformation

import com.inbergmarcano.mycvapp.rest.events.GetResumeFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetResumeSuccessEvent
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformationDataManager
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class BasicInformationPresenter: BasicInformationContract.Presenter{

    private lateinit var mView: BasicInformationContract.View
    private lateinit var mDataManager: BasicInformationDataManager


    @Inject override fun subscribe(view: BasicInformationContract.View, dataManager: BasicInformationDataManager) {
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
    override fun onGetResumeBasicInformationSuccess(getResumeSuccessEvent: GetResumeSuccessEvent) {
        mView.loadDataSuccess(getResumeSuccessEvent.basicInformations)

    }

    @Subscribe
    override fun onGetResumeBasicInformationFailure(getResumeFailureEvent: GetResumeFailureEvent) {
        mView.showErrorMessage(getResumeFailureEvent.message)
    }
}