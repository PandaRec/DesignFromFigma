package com.example.designfromfigma2.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.R
import com.example.designfromfigma2.pojo.BestSellerMenu
import kotlinx.android.synthetic.main.best_seller_item.view.*

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {
    var context : Context? = null
    var onLikeClickListener: OnLikeClickListener?=null
    var someList = listOf<BestSellerMenu>()
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
        val current = someList[position]
        holder.imageViewMain.setImageDrawable(context?.let { ResourcesCompat.getDrawable(it.resources,current.imageId,null) })
        holder.textViewTitle.text = current.fullTitle
        holder.textViewPrice.text = current.price
        holder.textViewOldPrice.text = current.oldPrice
        holder.textViewOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        //someTextView.setPaintFlags(someTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG)
        holder.itemView.setOnClickListener { onLikeClickListener?.onLikeClick(position) }

        if(current.isLiked){
            holder.imageViewLike.setImageDrawable(context?.let { ResourcesCompat.getDrawable(it.resources,R.drawable.ic_like,null) })

        }else{
            holder.imageViewLike.setImageDrawable(context?.let { ResourcesCompat.getDrawable(it.resources,R.drawable.ic_menu_not_like,null) })

        }

    }

    override fun getItemCount() = someList.size

    inner class BestSellerViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val imageViewMain = itemView.imageViewLeft
        val textViewPrice = itemView.textViewPrice
        val textViewOldPrice = itemView.textViewOldPrice
        val textViewTitle = itemView.textViewFullTitle
        val imageViewLike = itemView.imageViewLike
    }

    interface OnLikeClickListener{
        fun onLikeClick(position: Int)
    }
}