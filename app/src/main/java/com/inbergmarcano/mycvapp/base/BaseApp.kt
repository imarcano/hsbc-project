package com.inbergmarcano.mycvapp.base


import android.app.Application
import android.provider.SyncStateContract
import com.inbergmarcano.mycvapp.BuildConfig
import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.di.component.DaggerApplicationComponent
import com.inbergmarcano.mycvapp.di.module.ApplicationModule
import com.inbergmarcano.mycvapp.di.module.RestModule
import com.inbergmarcano.mycvapp.utils.Constants

class BaseApp: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
    }

    private fun setup() {
        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).restModule(RestModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}