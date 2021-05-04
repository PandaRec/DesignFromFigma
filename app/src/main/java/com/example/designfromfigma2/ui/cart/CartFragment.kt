package com.example.designfromfigma2.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.R
import com.example.designfromfigma2.adapters.CartAdapter
import kotlinx.android.synthetic.main.fragment_cart.view.*
import kotlinx.android.synthetic.main.top_of_cart_layout.view.*

class CartFragment: Fragment() {
    //todo: trash
    //todo: minus, plus
    //todo: recalculate total
    //todo: add disposable and override onDestroy

    lateinit var cartViewModel: CartViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        cartViewModel=
                ViewModelProvider(this).get(CartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cart, container, false)
        val navController = NavHostFragment.findNavController(this)


        root.roundedBack.setOnClickListener {
            navController.navigate(R.id.navigation_home)
        }

        val recyclerViewCart = root.recyclerViewCart
        val adapter = CartAdapter()
        initializeRecyclerViewCart(recyclerViewCart,adapter)
        return root
    }

    private fun initializeRecyclerViewCart(recyclerView:RecyclerView, adapter:CartAdapter ){
        cartViewModel.getCart().subscribe({
            recyclerView.adapter = adapter
            adapter.cartItems = it
        },{
            Log.d("TAG",it.message.toString())
        })


    }
}