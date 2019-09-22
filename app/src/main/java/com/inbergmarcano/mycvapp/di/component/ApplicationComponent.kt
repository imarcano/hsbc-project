package com.inbergmarcano.mycvapp.di.component

import android.app.Application
import android.content.Context
import com.inbergmarcano.mycvapp.base.BaseApp
import com.inbergmarcano.mycvapp.di.module.ActivityModule
import com.inbergmarcano.mycvapp.di.module.ApplicationModule
import com.inbergmarcano.mycvapp.di.module.RestModule
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.Binds
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, RestModule::class))
interface ApplicationComponent {
    fun inject(application: Application)

    fun getResumeEndpoints(): ResumeEndpoints

}