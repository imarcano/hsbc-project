package com.inbergmarcano.mycvapp.di.component

import com.inbergmarcano.mycvapp.di.module.ActivityModule
import com.inbergmarcano.mycvapp.di.module.ApplicationModule
import com.inbergmarcano.mycvapp.di.module.FragmentModule
import com.inbergmarcano.mycvapp.di.module.RestModule
import com.inbergmarcano.mycvapp.di.scope.PerActivity
import com.inbergmarcano.mycvapp.di.scope.PerApplication
import com.inbergmarcano.mycvapp.ui.basicinformation.BasicInformationFragment
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(basicInformationFragment: BasicInformationFragment)
}