package com.inbergmarcano.mycvapp.ui.basicinformation

import com.inbergmarcano.mycvapp.base.BaseFragmentContract
import com.inbergmarcano.mycvapp.rest.events.GetResumeFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetResumeSuccessEvent
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformationDataManager


class BasicInformationContract {

    interface View: BaseFragmentContract.View {
        fun showErrorMessage(error: String)
        fun loadDataSuccess(basicInformations: ArrayList<BasicInformation>)
    }

    interface Presenter: BaseFragmentContract.Presenter<View,BasicInformationDataManager> {
        fun loadData()
        fun onGetResumeBasicInformationSuccess(getResumeSuccessEvent: GetResumeSuccessEvent)
        fun onGetResumeBasicInformationFailure(getResumeFailureEvent: GetResumeFailureEvent)
    }
}