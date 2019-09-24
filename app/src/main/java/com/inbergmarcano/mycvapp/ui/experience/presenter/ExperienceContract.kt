package com.inbergmarcano.mycvapp.ui.experience.presenter

import com.inbergmarcano.mycvapp.base.BaseContract
import com.inbergmarcano.mycvapp.rest.events.GetExperienceFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetExperienceSuccessEvent
import com.inbergmarcano.mycvapp.ui.experience.model.Experience
import com.inbergmarcano.mycvapp.ui.experience.model.ExperienceDataManager


class ExperienceContract {

    interface View: BaseContract.View {
        fun showErrorMessage(error: String)
        fun loadDataSuccess(experiences: ArrayList<Experience>)
    }

    interface Presenter: BaseContract.Presenter<View, DataManager> {
        fun loadData()
        fun onGetExperienceSuccess(getExperienceSuccessEvent: GetExperienceSuccessEvent)
        fun onGetExperienceFailure(getExperienceFailureEvent: GetExperienceFailureEvent)
    }

    interface DataManager {
        fun getResumeExperience()
    }
}