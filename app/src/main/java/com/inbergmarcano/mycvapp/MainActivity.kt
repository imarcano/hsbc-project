package com.inbergmarcano.mycvapp

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import com.inbergmarcano.mycvapp.base.BaseActivity
import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.di.component.DaggerActivityComponent
import com.inbergmarcano.mycvapp.di.module.ActivityModule

class MainActivity : BaseActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun configureComponent(applicationComponent: ApplicationComponent) {
        DaggerActivityComponent.builder().applicationComponent(applicationComponent).activityModule(ActivityModule(this)).build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_basic_information, R.id.nav_profile,
                R.id.nav_experience, R.id.nav_knowledge, R.id.nav_experience
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
