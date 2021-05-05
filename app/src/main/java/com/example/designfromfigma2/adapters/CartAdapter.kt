package com.example.designfromfigma2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.designfromfigma2.R
import com.example.designfromfigma2.pojo.BestSellerMenu
import com.example.designfromfigma2.pojo.CartItem
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdapter: RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    var onTrashClickListener:OnTrashClickListener?=null
    var onMinusClickListener:OnMinusClickListener?=null
    var onPlusClickListener:OnPlusClickListener?=null
     var cartItems = listOf<CartItem>()
    set(value) {
        field=value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val current = cartItems[position]
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
            itemView.iconTrash.setOnClickListener { onTrashClickListener?.onTrashClick()}
            itemView.minus.setOnClickListener { onMinusClickListener?.onMinusClick() }
            itemView.plus.setOnClickListener { onPlusClickListener?.onPlusClick() }
        }

    }
    interface OnTrashClickListener{
        fun onTrashClick()
    }

    interface OnMinusClickListener{
        fun onMinusClick()
    }
    interface OnPlusClickListener{
        fun onPlusClick()
    }
}