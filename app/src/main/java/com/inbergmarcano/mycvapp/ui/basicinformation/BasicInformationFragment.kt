package com.inbergmarcano.mycvapp.ui.basicinformation

import com.inbergmarcano.mycvapp.base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.inbergmarcano.mycvapp.R
import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.di.component.DaggerFragmentComponent
import com.inbergmarcano.mycvapp.di.module.FragmentModule
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformationDataManager
import kotlinx.android.synthetic.main.fragment_basic_information.*
import javax.inject.Inject



class BasicInformationFragment: BaseFragment(), BasicInformationContract.View {

    @Inject lateinit var mPresenter: BasicInformationContract.Presenter
    @Inject lateinit var mResumeEndpoints: ResumeEndpoints


    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        DaggerFragmentComponent.builder().applicationComponent(applicationComponent)
            .fragmentModule(FragmentModule())
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
        mPresenter.subscribe(this,BasicInformationDataManager(mResumeEndpoints))
        mPresenter.loadData()

    }

    override fun onStop() {
        super.onStop()
        mPresenter.unsubscribe()
    }


    override fun showErrorMessage(error: String) {
        dismissProgressBar()
    }

    override fun loadDataSuccess(basicInformations: ArrayList<BasicInformation>) {
        dismissProgressBar()
        val adapter = BasicInformationAdapter(context!!,basicInformations)
        recyclerView!!.setLayoutManager(LinearLayoutManager(activity))
        recyclerView!!.setAdapter(adapter)
    }

}