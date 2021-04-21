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
import androidx.navigation.ui.setupWithNavController
import com.example.designfromfigma2.ui.start_page.StartPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() { // создание активити. AppCompatActivity - позволяет внедрить новые штуки в старые версии андроида
    var bottomNavigationView: ConstraintLayout?=null // создаю переменную своего bottom navigation для того

    override fun onCreate(savedInstanceState: Bundle?) { // отрисовка активности
        super.onCreate(savedInstanceState) // метод родителя
        setContentView(R.layout.activity_main) // связывавем данную активнсть с ее layout
        bottomNavigationView = findViewById(R.id.bottom_nav) // присваем переменной нужный элемент из layout




//        if(bottomNavigationView==null)
//            Log.d("TAG","null!!! Main")


//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//
//        val homeFragment = HomeFragment()
//        fragmentTransaction.add(R.id.nav_host_fragment,homeFragment).commit()





    }

}