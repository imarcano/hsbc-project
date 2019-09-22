package com.inbergmarcano.mycvapp.ui.profile.view

import com.inbergmarcano.mycvapp.base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inbergmarcano.mycvapp.R
import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.ui.profile.di.ProfileFragmentModule
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.ui.profile.di.DaggerProfileFragmentComponent
import com.inbergmarcano.mycvapp.ui.profile.model.Profile
import com.inbergmarcano.mycvapp.ui.profile.model.ProfileDataManager
import com.inbergmarcano.mycvapp.ui.profile.presenter.ProfileContract
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject



class ProfileFragment: BaseFragment(), ProfileContract.View {

    @Inject lateinit var mPresenter: ProfileContract.Presenter
    @Inject lateinit var mResumeEndpoints: ResumeEndpoints


    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        DaggerProfileFragmentComponent.builder().applicationComponent(applicationComponent)
            .profileFragmentModule(ProfileFragmentModule())
            .build().inject(this)
    }

    override fun getLayoutView(): Int {
        return R.layout.fragment_profile
    }

    override fun onViewReady(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
        view: View
    ) {
        showProgressBar()
        mPresenter.subscribe(this, ProfileDataManager(mResumeEndpoints))
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

    override fun loadDataSuccess(profile: Profile) {
        dismissProgressBar()
        profile_text.text = profile.content
    }

}