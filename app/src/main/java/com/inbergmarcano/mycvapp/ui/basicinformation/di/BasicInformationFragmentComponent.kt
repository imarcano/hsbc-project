package com.inbergmarcano.mycvapp.ui.basicinformation.di

import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import com.inbergmarcano.mycvapp.di.scopes.PerFragment
import com.inbergmarcano.mycvapp.ui.basicinformation.view.BasicInformationFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [BasicInformationFragmentModule::class])
interface BasicInformationFragmentComponent {
    fun inject(basicInformationFragment: BasicInformationFragment)
}