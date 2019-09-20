package com.inbergmarcano.mycvapp.di.module

import android.app.Activity
import com.inbergmarcano.mycvapp.MainContract
import com.inbergmarcano.mycvapp.MainPresenter
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