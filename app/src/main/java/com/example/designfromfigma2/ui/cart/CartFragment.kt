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
import com.example.designfromfigma2.pojo.CartItem
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.cart_item.view.*
import kotlinx.android.synthetic.main.fragment_cart.view.*
import kotlinx.android.synthetic.main.top_of_cart_layout.view.*

class CartFragment: Fragment() {
    //todo: trash
    //todo: minus, plus
    //todo: recalculate total
    //todo: add disposable and override onDestroy

    lateinit var cartViewModel: CartViewModel
    private var compositeDisposable = CompositeDisposable()
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

        adapter.onTrashClickListener = object : CartAdapter.OnTrashClickListener{
            override fun onTrashClick(item:CartItem) {
                Log.d("TAG","trash clicked")
                cartViewModel.deleteItemFromCart(item._id)
                initializeRecyclerViewCart(recyclerViewCart,adapter)

            }
        }
        adapter.onMinusClickListener = object : CartAdapter.OnMinusClickListener{
            override fun onMinusClick(item:CartItem) {
                val count = item.counter-1

                cartViewModel.updateCartItem(
                        item._id,
                        item.price,
                        item.fullTitle,
                        item.image,
                        item.id,
                        count
                )
                initializeRecyclerViewCart(recyclerViewCart,adapter)
            }
        }

        adapter.onPlusClickListener = object :CartAdapter.OnPlusClickListener{
            override fun onPlusClick(item:CartItem) {
                val count = item.counter+1

                cartViewModel.updateCartItem(
                        item._id,
                        item.price,
                        item.fullTitle,
                        item.image,
                        item.id,
                        count
                )
                initializeRecyclerViewCart(recyclerViewCart,adapter)
                adapter.notifyDataSetChanged()
            }
        }

        return root
    }

    private fun initializeRecyclerViewCart(recyclerView:RecyclerView, adapter:CartAdapter ){
        val disp = cartViewModel.getCart().subscribe({
            recyclerView.adapter = adapter
            adapter.cartItems = it
        },{
            Log.d("TAG",it.message.toString())
        })
        compositeDisposable.add(disp)


    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}