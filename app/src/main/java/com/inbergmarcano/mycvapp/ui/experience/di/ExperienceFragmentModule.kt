package com.inbergmarcano.mycvapp.ui.experience.di

import com.inbergmarcano.mycvapp.ui.basicinformation.presenter.BasicInformationContract
import com.inbergmarcano.mycvapp.ui.basicinformation.presenter.BasicInformationPresenter
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperienceContract
import com.inbergmarcano.mycvapp.ui.experience.presenter.ExperiencePresenter
import dagger.Module
import dagger.Provides

@Module
class ExperienceFragmentModule {

    @Provides
    fun providePresenter(): ExperienceContract.Presenter {
        return ExperiencePresenter()
    }

}