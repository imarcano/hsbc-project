package com.inbergmarcano.mycvapp.ui.basicinformation.di

import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.di.scope.PerFragment
import com.inbergmarcano.mycvapp.ui.basicinformation.view.BasicInformationFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [BasicInformationFragmentModule::class])
interface BasicInformationFragmentComponent {
    fun inject(basicInformationFragment: BasicInformationFragment)
}