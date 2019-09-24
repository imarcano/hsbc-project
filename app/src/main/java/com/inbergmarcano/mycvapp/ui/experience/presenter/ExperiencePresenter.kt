package com.inbergmarcano.mycvapp.ui.experience.presenter

import com.inbergmarcano.mycvapp.rest.events.GetExperienceFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetExperienceSuccessEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class ExperiencePresenter:
    ExperienceContract.Presenter {

    private lateinit var mView: ExperienceContract.View
    private lateinit var mDataManager: ExperienceContract.DataManager


    @Inject override fun subscribe(view: ExperienceContract.View, dataManager: ExperienceContract.DataManager) {
        EventBus.getDefault().register(this)
        mView = view
        mDataManager = dataManager
    }

    override fun unsubscribe() {
        EventBus.getDefault().unregister(this)
    }

    override fun loadData() {
        mDataManager.getResumeExperience()
    }


    @Subscribe
    override fun onGetExperienceSuccess(getExperienceSuccessEvent: GetExperienceSuccessEvent) {
        mView.loadDataSuccess(getExperienceSuccessEvent.experiences)

    }

    @Subscribe
    override fun onGetExperienceFailure(getExperienceFailureEvent: GetExperienceFailureEvent) {
        mView.showErrorMessage(getExperienceFailureEvent.message)
    }
}