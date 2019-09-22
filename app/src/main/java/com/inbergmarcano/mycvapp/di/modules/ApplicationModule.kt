package com.inbergmarcano.mycvapp.di.modules

import com.inbergmarcano.mycvapp.base.BaseApp
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    fun provideApplication(): BaseApp {
        return baseApp
    }



}