package com.inbergmarcano.mycvapp.ui.main.di

import android.app.Activity
import com.inbergmarcano.mycvapp.ui.main.presenter.MainContract
import com.inbergmarcano.mycvapp.ui.main.presenter.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}