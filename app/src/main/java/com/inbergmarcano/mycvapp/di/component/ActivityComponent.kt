package com.inbergmarcano.mycvapp.di.component

import com.inbergmarcano.mycvapp.MainActivity
import com.inbergmarcano.mycvapp.di.module.ActivityModule
import com.inbergmarcano.mycvapp.di.scope.PerActivity
import com.inbergmarcano.mycvapp.di.scope.PerApplication
import dagger.Component
import javax.inject.Singleton

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}