package com.inbergmarcano.mycvapp.ui.main.di

import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import com.inbergmarcano.mycvapp.ui.main.view.MainActivity
import com.inbergmarcano.mycvapp.di.scopes.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}