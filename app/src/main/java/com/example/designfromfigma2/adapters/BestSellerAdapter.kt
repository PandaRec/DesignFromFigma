package com.example.designfromfigma2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.R
import kotlinx.android.synthetic.main.best_seller_item.view.*

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {
    var context : Context? = null
    var someList = listOf<Int>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_item,parent,false)
        context = parent.context
        return BestSellerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.imageViewMain.setImageDrawable(context?.let { ResourcesCompat.getDrawable(it.resources,someList[position],null) })

    }

    override fun getItemCount() = someList.size

    inner class BestSellerViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val imageViewMain = itemView.imageViewLeft
    }
}