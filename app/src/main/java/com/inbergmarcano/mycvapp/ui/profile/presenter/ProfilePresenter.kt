package com.inbergmarcano.mycvapp.ui.profile.presenter

import com.inbergmarcano.mycvapp.rest.events.GetProfileFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetProfileSuccessEvent
import com.inbergmarcano.mycvapp.ui.profile.model.ProfileDataManager
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class ProfilePresenter: ProfileContract.Presenter {

    private lateinit var mView: ProfileContract.View
    private lateinit var mDataManager: ProfileDataManager


    @Inject override fun subscribe(view: ProfileContract.View, dataManager: ProfileDataManager) {
        EventBus.getDefault().register(this)
        mView = view
        mDataManager = dataManager
    }

    override fun unsubscribe() {
        EventBus.getDefault().unregister(this)
    }

    override fun loadData() {
        mDataManager.getResumeProfile()
    }

    @Subscribe
    override fun onGetResumeBasicInformationSuccess(getProfileSuccessEvent: GetProfileSuccessEvent) {
        mView.loadDataSuccess(getProfileSuccessEvent.data)
    }

    @Subscribe
    override fun onGetResumeBasicInformationFailure(getProfileFailureEvent: GetProfileFailureEvent) {
        mView.showErrorMessage(getProfileFailureEvent.message)
    }
}