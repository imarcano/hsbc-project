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

    fun pushFragment(fragment: Fragment, vararg animations: Int){
        //pushFragment(fragment, R.id.frame, true, *animations)
    }

    private fun pushFragment(fragment: Fragment, container: Int, addToBackStack: Boolean, vararg animations: Int){
        val transaction: FragmentTransaction = mFragmentManager.beginTransaction()
        val fragmentClass: KClass<Fragment> = Fragment::class
        val tag: String? = fragmentClass.simpleName

        if(addToBackStack) transaction.addToBackStack(tag)

        when(animations.size){
            0-> transaction.setCustomAnimations(R.anim.push_show_in_simple, R.anim.push_hidden_out_simple,
                    0,
                    0)
            2 -> transaction.setCustomAnimations(animations[0], animations[1])
            4 -> transaction.setCustomAnimations(animations[0], animations[1], animations[2], animations[3])
            else -> throw Exception("Wrong amount of animations")
        }

        transaction.replace(container, fragment, tag)
        transaction.commit()
        mTagFragments.add(tag!!)
    }

    fun showFragment(fragment: Fragment, tag: String){
        val transaction: FragmentTransaction = mFragmentManager.beginTransaction()
        //transaction.replace(R.id.frame,fragment)
        transaction.commitAllowingStateLoss()
        mTagFragments.add(tag)

    }

    fun showProgressBar(){
        if(progressBar != null){
            progressBar!!.visibility = View.VISIBLE
        }
    }

    fun dismissProgressBar(){
        if(progressBar != null){
            progressBar!!.visibility = View.GONE
        }
    }


    fun toast(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }


    fun getLastFragmentTag(): String{
        if(mTagFragments.isEmpty()) return ""
        return mTagFragments.get(mTagFragments.size-1)
    }





}