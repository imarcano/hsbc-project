package com.inbergmarcano.mycvapp.ui.knowledge.di

import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.di.scope.PerFragment
import com.inbergmarcano.mycvapp.ui.knowledge.view.KnowledgeFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [KnowledgeFragmentModule::class])
interface KnowledgeFragmentComponent {
    fun inject(knowledgeFragment: KnowledgeFragment)
}