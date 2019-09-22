package com.inbergmarcano.mycvapp.ui.knowledge.di

import com.inbergmarcano.mycvapp.ui.knowledge.presenter.KnowledgeContract
import com.inbergmarcano.mycvapp.ui.knowledge.presenter.KnowledgePresenter
import dagger.Module
import dagger.Provides

@Module
class KnowledgeFragmentModule {

    @Provides
    fun providePresenter(): KnowledgeContract.Presenter {
        return KnowledgePresenter()
    }

}