package com.inbergmarcano.mycvapp.ui.main

import com.inbergmarcano.mycvapp.base.BaseContract
import com.inbergmarcano.mycvapp.rest.events.GetHeaderFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetHeaderSuccessEvent
import com.inbergmarcano.mycvapp.ui.main.model.HeaderDataManager

class MainContract {

    interface View: BaseContract.View{
        fun customizeHeaderName(name: String)
        fun customizeHeaderPicture(url: String)
        fun customizeHeaderEmail(email: String)
        fun showErrorMessage(msg: String)
    }

    interface Presenter: BaseContract.Presenter<View, HeaderDataManager>{
        fun loadData()
        fun onGetResumeBasicInformationSuccess(getHeaderSuccessEvent: GetHeaderSuccessEvent)
        fun onGetResumeBasicInformationFailure(getHeaderFailureEvent: GetHeaderFailureEvent)
    }
}