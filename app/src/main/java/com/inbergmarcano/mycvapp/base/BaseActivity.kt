package com.inbergmarcano.mycvapp.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.inbergmarcano.mycvapp.di.components.ApplicationComponent
import kotlinx.android.synthetic.main.content_main.*


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