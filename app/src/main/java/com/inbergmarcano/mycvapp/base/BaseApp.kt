package com.inbergmarcano.mycvapp.base


import android.app.Application
import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import com.inbergmarcano.mycvapp.di.components.DaggerApplicationComponent
import com.inbergmarcano.mycvapp.di.modules.ApplicationModule
import com.inbergmarcano.mycvapp.di.modules.RestModule

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