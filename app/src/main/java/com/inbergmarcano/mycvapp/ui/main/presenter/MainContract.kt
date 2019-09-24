package com.inbergmarcano.mycvapp.ui.main.presenter

import android.provider.ContactsContract
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

    interface Presenter: BaseContract.Presenter<View, DataManager>{
        fun loadData()
        fun onGetResumeHeaderSuccess(getHeaderSuccessEvent: GetHeaderSuccessEvent)
        fun onGetResumeHeaderFailure(getHeaderFailureEvent: GetHeaderFailureEvent)
    }

    interface DataManager{
        fun getResumeHeader()
    }
}