package com.inbergmarcano.mycvapp.ui.experience.presenter

import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationsFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationsSuccessEvent
import com.inbergmarcano.mycvapp.rest.events.GetExperienceFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetExperienceSuccessEvent
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformationDataManager
import com.inbergmarcano.mycvapp.ui.experience.model.ExperienceDataManager
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperienceContract
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class ExperiencePresenter:
    ExperienceContract.Presenter {

    private lateinit var mView: ExperienceContract.View
    private lateinit var mDataManager: ExperienceDataManager


    @Inject override fun subscribe(view: ExperienceContract.View, dataManager: ExperienceDataManager) {
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