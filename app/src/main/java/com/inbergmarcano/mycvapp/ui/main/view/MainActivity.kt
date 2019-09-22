package com.inbergmarcano.mycvapp.ui.main.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.inbergmarcano.mycvapp.R
import com.inbergmarcano.mycvapp.base.BaseActivity
import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import com.inbergmarcano.mycvapp.ui.main.di.ActivityModule
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.ui.main.presenter.MainContract
import com.inbergmarcano.mycvapp.ui.main.di.DaggerActivityComponent
import com.inbergmarcano.mycvapp.ui.main.model.HeaderDataManager
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navView: NavigationView
    @Inject lateinit var mPresenter: MainContract.Presenter
    @Inject lateinit var mResumeEndpoints: ResumeEndpoints


    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun configureComponent(applicationComponent: ApplicationComponent) {
        DaggerActivityComponent.builder().applicationComponent(applicationComponent).activityModule(
            ActivityModule(this)
        ).build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_basic_information,
                R.id.nav_profile,
                R.id.nav_experience,
                R.id.nav_knowledge,
                R.id.nav_experience
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        mPresenter.subscribe(this,
            HeaderDataManager(mResumeEndpoints)
        )
        mPresenter.loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun customizeHeaderName(name: String) {
        val headerView = navView.getHeaderView(0)
        val headerName: TextView = headerView.findViewById(R.id.header_name)
        headerName.text = name
        navView.invalidate()
    }

    override fun customizeHeaderPicture(url: String) {
        val headerView = navView.getHeaderView(0)
        val headerPicture: ImageView = headerView.findViewById(R.id.header_picture)
        Glide.with(this).load(url).into(headerPicture)
    }

    override fun customizeHeaderEmail(email: String) {
        val headerView = navView.getHeaderView(0)
        val headerEmail: TextView = headerView.findViewById(R.id.header_email)
        headerEmail.text = email
        navView.invalidate()
    }

    override fun showErrorMessage(msg: String) {
        toast(msg)
    }
}
