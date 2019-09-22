package com.inbergmarcano.mycvapp.di.components

import android.app.Application
import com.inbergmarcano.mycvapp.di.modules.ApplicationModule
import com.inbergmarcano.mycvapp.di.modules.RestModule
import com.inbergmarcano.mycvapp.di.scopes.PerApplication
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import dagger.Component

@PerApplication
@Component(modules = arrayOf(ApplicationModule::class, RestModule::class))
interface ApplicationComponent {
    fun inject(application: Application)

    fun getResumeEndpoints(): ResumeEndpoints

}