package com.inbergmarcano.mycvapp.ui.profile.di

import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import com.inbergmarcano.mycvapp.di.scopes.PerFragment
import com.inbergmarcano.mycvapp.ui.profile.view.ProfileFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [ProfileFragmentModule::class])
interface ProfileFragmentComponent {
    fun inject(profileFragment: ProfileFragment)
}