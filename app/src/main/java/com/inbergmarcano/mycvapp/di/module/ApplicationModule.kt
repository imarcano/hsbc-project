package com.inbergmarcano.mycvapp.di.module

import android.app.Application
import com.inbergmarcano.mycvapp.base.BaseApp
import com.inbergmarcano.mycvapp.di.scope.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    fun provideApplication(): BaseApp {
        return baseApp
    }



}