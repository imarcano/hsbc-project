package com.inbergmarcano.mycvapp.ui.basicinformation.di

import com.inbergmarcano.mycvapp.ui.basicinformation.BasicInformationContract
import com.inbergmarcano.mycvapp.ui.basicinformation.BasicInformationPresenter
import com.inbergmarcano.mycvapp.ui.profile.ProfileContract
import com.inbergmarcano.mycvapp.ui.profile.ProfilePresenter
import dagger.Module
import dagger.Provides

@Module
class BasicInformationFragmentModule {

    @Provides
    fun providePresenter(): BasicInformationContract.Presenter {
        return BasicInformationPresenter()
    }

}