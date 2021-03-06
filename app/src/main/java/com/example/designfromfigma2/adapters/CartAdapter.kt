package com.example.designfromfigma2.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.designfromfigma2.R
import com.example.designfromfigma2.pojo.CartItem
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdapter: RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    val BHTrash:BehaviorSubject<CartItem> = BehaviorSubject.create()
    val BHMinus:BehaviorSubject<CartItem> = BehaviorSubject.create()
    val BHPlus:BehaviorSubject<CartItem> = BehaviorSubject.create()

    var cartItems = listOf<CartItem>()
    set(value) {
        field=value
        notifyDataSetChanged()
        Log.d("TAG","updated")
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val current = cartItems[position]
        Log.d("TAGTEST",current.counter.toString())
        holder.updateUI(current)
    }

    override fun getItemCount() = cartItems.size

    inner class CartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView = itemView.imageViewCart
        val textViewTitle = itemView.textViewTitleCart
        val textViewPrice = itemView.textViewPriceCart
        val counter = itemView.counter

        fun updateUI(current:CartItem){
            Glide.with(itemView).load(current.image).into(imageView)
            textViewTitle.text = current.fullTitle
            textViewPrice.text = current.price
            counter.text = current.counter.toString()
            itemView.iconTrash.setOnClickListener { BHTrash.onNext(current) }
            itemView.minus.setOnClickListener{BHMinus.onNext(current)}
            itemView.plus.setOnClickListener{BHPlus.onNext(current)}
        }

    }

}