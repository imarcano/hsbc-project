package com.inbergmarcano.mycvapp.ui.profile.presenter

import com.inbergmarcano.mycvapp.base.BaseContract
import com.inbergmarcano.mycvapp.rest.events.GetProfileFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetProfileSuccessEvent
import com.inbergmarcano.mycvapp.ui.profile.model.Profile
import com.inbergmarcano.mycvapp.ui.profile.model.ProfileDataManager


class ProfileContract {

    interface View: BaseContract.View {
        fun showErrorMessage(error: String)
        fun loadDataSuccess(profile: Profile)
    }

    interface Presenter: BaseContract.Presenter<View, DataManager> {
        fun loadData()
        fun onGetResumeBasicInformationSuccess(getProfileSuccessEvent: GetProfileSuccessEvent)
        fun onGetResumeBasicInformationFailure(getProfileFailureEvent: GetProfileFailureEvent)
    }

    interface DataManager {
        fun getResumeProfile()
    }
}