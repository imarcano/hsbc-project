package com.inbergmarcano.mycvapp.ui.knowledge.presenter

import com.inbergmarcano.mycvapp.rest.events.GetKnowledgeFailureEvent
import com.inbergmarcano.mycvapp.rest.events.GetKnowledgeSuccessEvent
import com.inbergmarcano.mycvapp.ui.knowledge.model.KnowledgeDataManager
import com.inbergmarcano.mycvapp.ui.knowledge.presenter.KnowledgeContract
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class KnowledgePresenter:
    KnowledgeContract.Presenter {

    private lateinit var mView: KnowledgeContract.View
    private lateinit var mDataManager: KnowledgeDataManager


    @Inject override fun subscribe(view: KnowledgeContract.View, dataManager: KnowledgeDataManager) {
        EventBus.getDefault().register(this)
        mView = view
        mDataManager = dataManager
    }

    override fun unsubscribe() {
        EventBus.getDefault().unregister(this)
    }

    override fun loadData() {
        mDataManager.getResumeKnowledge()
    }


    @Subscribe
    override fun onGetResumeBasicInformationSuccess(getKnowledgeSuccessEvent: GetKnowledgeSuccessEvent) {
        mView.loadDataSuccess(getKnowledgeSuccessEvent.knowledge)

    }

    @Subscribe
    override fun onGetResumeBasicInformationFailure(getKnowledgeFailureEvent: GetKnowledgeFailureEvent) {
        mView.showErrorMessage(getKnowledgeFailureEvent.message)
    }
}