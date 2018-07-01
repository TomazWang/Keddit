package com.tomazium.project.keddit

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if(savedInstanceState == null){
            changeFragment(NewsFragment())
        }

    }

    fun changeFragment(f:Fragment, cleanStack: Boolean = false){
        val ft = fragmentManager.beginTransaction()

        if (cleanStack){
            clearBackStack()
        }

        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
        ft.replace(R.id.activity_base_content, f)
        ft.addToBackStack(null)
        ft.commit()


    }


    fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }




}
