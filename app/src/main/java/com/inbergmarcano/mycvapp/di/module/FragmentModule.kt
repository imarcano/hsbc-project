package com.inbergmarcano.mycvapp.di.module

import com.inbergmarcano.mycvapp.di.scope.PerApplication
import com.inbergmarcano.mycvapp.ui.basicinformation.BasicInformationContract
import com.inbergmarcano.mycvapp.ui.basicinformation.BasicInformationPresenter
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FragmentModule {

    @Provides
    fun providePresenter(): BasicInformationContract.Presenter {
        return BasicInformationPresenter()
    }

}