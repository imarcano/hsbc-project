package com.inbergmarcano.mycvapp.ui.profile.di

import com.inbergmarcano.mycvapp.ui.profile.presenter.ProfileContract
import com.inbergmarcano.mycvapp.ui.profile.presenter.ProfilePresenter
import dagger.Module
import dagger.Provides

@Module
class ProfileFragmentModule {

    @Provides
    fun providePresenter(): ProfileContract.Presenter {
        return ProfilePresenter()
    }

}