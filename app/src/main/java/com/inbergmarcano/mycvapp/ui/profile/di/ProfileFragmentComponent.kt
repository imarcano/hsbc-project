package com.inbergmarcano.mycvapp.ui.profile.di

import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.di.scope.PerFragment
import com.inbergmarcano.mycvapp.ui.profile.ProfileFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [ProfileFragmentModule::class])
interface ProfileFragmentComponent {
    fun inject(profileFragment: ProfileFragment)
}