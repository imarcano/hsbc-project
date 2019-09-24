package com.inbergmarcano.mycvapp.ui.basicinformation.presenter

import com.inbergmarcano.mycvapp.base.BaseContract
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationSuccessEvent
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation


class BasicInformationContract {

    interface View: BaseContract.View {
        fun showErrorMessage(error: String)
        fun loadDataSuccess(basicInformations: ArrayList<BasicInformation>)
    }

    interface Presenter: BaseContract.Presenter<View, DataManager> {
        fun loadData()
        fun onGetResumeBasicInformationSuccess(getBasicInformationSuccessEvent: GetBasicInformationSuccessEvent)
        fun onGetResumeBasicInformationFailure(getBasicInformationFailureEvent: GetBasicInformationFailureEvent)
    }

    interface DataManager{
        fun getResumeBasicInformation()
    }
}