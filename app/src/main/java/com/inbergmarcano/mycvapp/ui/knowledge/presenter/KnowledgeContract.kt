package com.inbergmarcano.mycvapp.ui.knowledge.presenter

import com.inbergmarcano.mycvapp.base.BaseContract
import com.inbergmarcano.mycvapp.rest.events.GetKnowledgeFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetKnowledgeSuccessEvent
import com.inbergmarcano.mycvapp.ui.knowledge.model.Knowledge
import com.inbergmarcano.mycvapp.ui.knowledge.model.KnowledgeDataManager


class KnowledgeContract {

    interface View: BaseContract.View {
        fun showErrorMessage(error: String)
        fun loadDataSuccess(knowledge: ArrayList<Knowledge>)
    }

    interface Presenter: BaseContract.Presenter<View, DataManager> {
        fun loadData()
        fun onGetResumeBasicInformationSuccess(getKnowledgeSuccessEvent: GetKnowledgeSuccessEvent)
        fun onGetResumeBasicInformationFailure(getKnowledgeFailureEvent: GetKnowledgeFailureEvent)
    }

    interface DataManager{
        fun getResumeKnowledge()
    }
}