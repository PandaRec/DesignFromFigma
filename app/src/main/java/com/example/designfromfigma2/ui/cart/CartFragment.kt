package com.example.designfromfigma2.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.designfromfigma2.R
import kotlinx.android.synthetic.main.top_of_cart_layout.view.*

class CartFragment: Fragment() {
    lateinit var cartViewModel: CartViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        cartViewModel=
                ViewModelProvider(this).get(CartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cart, container, false)
        val navController = NavHostFragment.findNavController(this)


        root.roundedBack.setOnClickListener {
            Log.d("TAG","pressed back")
            navController.navigate(R.id.navigation_home)
        }
        return root
    }
}