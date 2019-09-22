package com.inbergmarcano.mycvapp.ui.experience.di

import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import com.inbergmarcano.mycvapp.di.scopes.PerFragment
import com.inbergmarcano.mycvapp.ui.experience.view.ExperienceFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [ExperienceFragmentModule::class])
interface ExperienceFragmentComponent {
    fun inject(experienceFragment: ExperienceFragment)
}