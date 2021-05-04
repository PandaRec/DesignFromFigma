package com.example.designfromfigma2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var bottomNavigationView: ConstraintLayout?=null
    private var imageViewBacket:ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_nav)
        imageViewBacket = backet
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        imageViewBacket?.setOnClickListener {
            Log.d("TAG","goto cart")
            bottomNavigationView?.visibility=View.GONE
            navController.navigate(R.id.navigation_cart)
        }


    }

}