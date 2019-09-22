package com.inbergmarcano.mycvapp.di.module

import android.app.Activity
import com.inbergmarcano.mycvapp.MainContract
import com.inbergmarcano.mycvapp.MainPresenter
import com.inbergmarcano.mycvapp.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    @Singleton
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @Singleton
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}