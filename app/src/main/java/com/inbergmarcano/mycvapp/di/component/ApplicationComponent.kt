package com.inbergmarcano.mycvapp.di.component

import com.inbergmarcano.mycvapp.base.BaseApp
import com.inbergmarcano.mycvapp.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}