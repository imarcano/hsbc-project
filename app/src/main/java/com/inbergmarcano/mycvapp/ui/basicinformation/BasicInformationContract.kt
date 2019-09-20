package com.inbergmarcano.mycvapp.ui.basicinformation

import com.inbergmarcano.mycvapp.base.BaseContract
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation


class BasicInformationContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<BasicInformation>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData()
    }
}