package com.example.designfromfigma2

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.designfromfigma2.ui.home.HomeFragment
import com.example.designfromfigma2.ui.start_page.StartPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var bottomNavigationView: ConstraintLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_nav)
        if(bottomNavigationView==null)
            Log.d("TAG","null!!! Main")


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val homeFragment = HomeFragment()
        fragmentTransaction.add(R.id.nav_host_fragment,homeFragment).commit()





    }
    fun changeVisibilityBottomNavigation(visible:Boolean){

        if(bottomNavigationView==null)
            Log.d("TAG","null!!!")

        if(visible){

            bottomNavigationView?.visibility = View.VISIBLE
        }else{
            bottomNavigationView?.visibility = View.GONE
        }
    }
}