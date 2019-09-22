package com.inbergmarcano.mycvapp.di.component

import android.app.Application
import com.inbergmarcano.mycvapp.di.module.ApplicationModule
import com.inbergmarcano.mycvapp.di.module.RestModule
import com.inbergmarcano.mycvapp.di.scope.PerApplication
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import dagger.Component

@PerApplication
@Component(modules = arrayOf(ApplicationModule::class, RestModule::class))
interface ApplicationComponent {
    fun inject(application: Application)

    fun getResumeEndpoints(): ResumeEndpoints

}