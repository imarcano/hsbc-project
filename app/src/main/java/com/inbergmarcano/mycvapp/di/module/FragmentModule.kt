package com.inbergmarcano.mycvapp.di.module

import com.inbergmarcano.mycvapp.ui.basicinformation.BasicInformationContract
import com.inbergmarcano.mycvapp.ui.basicinformation.BasicInformationPresenter
import com.inbergmarcano.mycvapp.ui.basicinformation.model.BasicInformation
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideListPresenter(): BasicInformationContract.Presenter {
        return BasicInformationPresenter()
    }

}