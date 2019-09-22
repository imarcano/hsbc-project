package com.inbergmarcano.mycvapp.ui.knowledge.view

import com.inbergmarcano.mycvapp.base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.inbergmarcano.mycvapp.R
import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.ui.knowledge.di.DaggerKnowledgeFragmentComponent
import com.inbergmarcano.mycvapp.ui.knowledge.di.KnowledgeFragmentModule
import com.inbergmarcano.mycvapp.ui.knowledge.model.Knowledge
import com.inbergmarcano.mycvapp.ui.knowledge.model.KnowledgeDataManager
import com.inbergmarcano.mycvapp.ui.knowledge.presenter.KnowledgeContract
import kotlinx.android.synthetic.main.fragment_basic_information.*
import javax.inject.Inject



class KnowledgeFragment: BaseFragment(),
    KnowledgeContract.View {

    @Inject lateinit var mPresenter: KnowledgeContract.Presenter
    @Inject lateinit var mResumeEndpoints: ResumeEndpoints


    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        DaggerKnowledgeFragmentComponent.builder().applicationComponent(applicationComponent)
            .knowledgeFragmentModule(KnowledgeFragmentModule())
            .build().inject(this)
    }

    override fun getLayoutView(): Int {
        return R.layout.fragment_basic_information
    }

    override fun onViewReady(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
        view: View
    ) {
        showProgressBar()
        mPresenter.subscribe(this, KnowledgeDataManager(mResumeEndpoints))
        mPresenter.loadData()

    }

    override fun onStop() {
        super.onStop()
        mPresenter.unsubscribe()
    }


    override fun showErrorMessage(error: String) {
        dismissProgressBar()
        toast(error)
    }

    override fun loadDataSuccess(knowledge: ArrayList<Knowledge>) {
        dismissProgressBar()
        val adapter = KnowledgeAdapter(
            context!!,
            knowledge
        )
        recyclerView!!.setLayoutManager(LinearLayoutManager(activity))
        recyclerView!!.setAdapter(adapter)
    }

}