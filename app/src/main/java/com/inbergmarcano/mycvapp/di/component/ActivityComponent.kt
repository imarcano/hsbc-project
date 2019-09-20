package com.inbergmarcano.mycvapp.di.component

import com.inbergmarcano.mycvapp.MainActivity
import com.inbergmarcano.mycvapp.di.module.ActivityModule
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}