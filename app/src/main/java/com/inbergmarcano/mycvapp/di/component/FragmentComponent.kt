package com.inbergmarcano.mycvapp.di.component

import com.inbergmarcano.mycvapp.di.module.FragmentModule
import com.inbergmarcano.mycvapp.ui.basicinformation.BasicInformationFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(basicInformationFragment: BasicInformationFragment)

}