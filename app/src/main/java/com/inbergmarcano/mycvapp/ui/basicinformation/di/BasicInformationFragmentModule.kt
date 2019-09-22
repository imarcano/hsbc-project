package com.inbergmarcano.mycvapp.ui.basicinformation.di

import com.inbergmarcano.mycvapp.ui.basicinformation.presenter.BasicInformationContract
import com.inbergmarcano.mycvapp.ui.basicinformation.presenter.BasicInformationPresenter
import dagger.Module
import dagger.Provides

@Module
class BasicInformationFragmentModule {

    @Provides
    fun providePresenter(): BasicInformationContract.Presenter {
        return BasicInformationPresenter()
    }

}