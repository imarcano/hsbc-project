package com.inbergmarcano.mycvapp.ui.experience.view

import com.inbergmarcano.mycvapp.base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.inbergmarcano.mycvapp.R
import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.ui.experience.di.DaggerExperienceFragmentComponent
import com.inbergmarcano.mycvapp.ui.experience.di.ExperienceFragmentModule
import com.inbergmarcano.mycvapp.ui.experience.model.Experience
import com.inbergmarcano.mycvapp.ui.experience.model.ExperienceDataManager
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperienceContract
import kotlinx.android.synthetic.main.fragment_basic_information.*
import javax.inject.Inject



class ExperienceFragment: BaseFragment(),
    ExperienceContract.View {

    @Inject lateinit var mPresenter: ExperienceContract.Presenter
    @Inject lateinit var mResumeEndpoints: ResumeEndpoints


    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        DaggerExperienceFragmentComponent.builder().applicationComponent(applicationComponent)
            .experienceFragmentModule(ExperienceFragmentModule())
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
        mPresenter.subscribe(this, ExperienceDataManager(mResumeEndpoints))
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

    override fun loadDataSuccess(experiences: ArrayList<Experience>) {
        dismissProgressBar()
        val adapter = ExperienceAdapter(
            context!!,
            experiences
        )
        recyclerView!!.setLayoutManager(LinearLayoutManager(activity))
        recyclerView!!.setAdapter(adapter)
    }

}