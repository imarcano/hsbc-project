package com.inbergmarcano.mycvapp.ui.basicinformation

import com.inbergmarcano.mycvapp.base.BaseContract
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationsFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetBasicInformationsSuccessEvent
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformationDataManager
import com.inbergmarcano.mycvapp.ui.profile.model.Profile
import com.inbergmarcano.mycvapp.ui.profile.model.ProfileDataManager


class BasicInformationContract {

    interface View: BaseContract.View {
        fun showErrorMessage(error: String)
        fun loadDataSuccess(basicInformations: ArrayList<BasicInformation>)
    }

    interface Presenter: BaseContract.Presenter<View, BasicInformationDataManager> {
        fun loadData()
        fun onGetResumeBasicInformationSuccess(getBasicInformationsSuccessEvent: GetBasicInformationsSuccessEvent)
        fun onGetResumeBasicInformationFailure(getBasicInformationsFailureEvent: GetBasicInformationsFailureEvent)
    }
}