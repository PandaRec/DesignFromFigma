package com.example.designfromfigma2.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.designfromfigma2.R
import com.example.designfromfigma2.pojo.BestSellerMenu
import kotlinx.android.synthetic.main.best_seller_item.view.*

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {
    var onItemClickListener: OnItemClickListener?=null
    var someList = listOf<BestSellerMenu>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_item,parent,false)
        return BestSellerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val current = someList[position]
        holder.itemView.setOnClickListener { onItemClickListener?.onItemClick(position) }
        holder.insertToUI(current)

    }

    override fun getItemCount() = someList.size

    inner class BestSellerViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val imageViewMain = itemView.imageViewLeft
        val textViewPrice = itemView.textViewPrice
        val textViewOldPrice = itemView.textViewOldPrice
        val textViewTitle = itemView.textViewFullTitle
        val imageViewLike = itemView.imageViewLike

        fun insertToUI(bestSeller: BestSellerMenu){
            Glide.with(itemView).load(bestSeller.imageId).into(imageViewMain)
            //imageViewMain.setImageResource(bestSeller.imageId)
            textViewTitle.setText(bestSeller.fullTitle)
            textViewPrice.setText( bestSeller.price)
            textViewOldPrice.setText(bestSeller.oldPrice)
            textViewOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

            if(bestSeller.isLiked){
                imageViewLike.setImageResource(R.drawable.ic_like)

            }else{
                imageViewLike.setImageResource(R.drawable.ic_menu_not_like)

            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}