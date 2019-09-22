package com.inbergmarcano.mycvapp.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.inbergmarcano.mycvapp.R
import com.inbergmarcano.mycvapp.di.component.ApplicationComponent
import com.inbergmarcano.mycvapp.di.component.DaggerApplicationComponent
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_basic_information.*
import kotlin.reflect.KClass



abstract class BaseActivity: AppCompatActivity() {

    private lateinit var mFragmentManager: FragmentManager

    private lateinit var mTagFragments: ArrayList<String>

    abstract fun getLayout(): Int
    abstract fun configureComponent(applicationComponent: ApplicationComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragmentManager = supportFragmentManager
        mTagFragments = ArrayList()
        setContentView(getLayout())
        configureComponent(BaseApp.instance.getApplicationComponent())
    }

    override fun onBackPressed() {
        if(!mTagFragments.isEmpty()) mTagFragments.removeAt(mTagFragments.size-1)
        super.onBackPressed()
    }

    fun showProgressBar(){
        if(progressBar != null){
            progressBar.visibility = View.VISIBLE
        }
    }

    fun dismissProgressBar(){
        if(progressBar != null){
            progressBar.visibility = View.INVISIBLE
        }
    }


    fun toast(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}