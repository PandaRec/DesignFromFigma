package com.example.designfromfigma2.adapters

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.designfromfigma2.R
import com.example.designfromfigma2.pojo.BestSellerMenu
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.best_seller_item.view.*

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {
    val BHItem:BehaviorSubject<Int> = BehaviorSubject.create()
    val BHLike: BehaviorSubject<BestSellerMenu> = BehaviorSubject.create()
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
        holder.itemView.setOnClickListener { BHItem.onNext(position) }
        holder.insertToUI(current)
        //holder.addListener(current)
        Log.d("TAG","insert invoke")
        Log.d("TAG","list size ${someList.size}")


    }

    override fun getItemCount() = someList.size

    inner class BestSellerViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val imageViewMain = itemView.imageViewLeft
        val textViewPrice = itemView.textViewPrice
        val textViewOldPrice = itemView.textViewOldPrice
        val textViewTitle = itemView.textViewFullTitle
        val imageViewLike = itemView.imageViewLike


        fun insertToUI(bestSeller: BestSellerMenu){
            imageViewLike.setOnClickListener { BHLike.onNext(bestSeller) }

            Log.d("TAG","--->${bestSeller.fullTitle}")
            Glide.with(itemView).load(bestSeller.image).into(imageViewMain)
            textViewTitle.text = bestSeller.fullTitle
            textViewPrice.text = bestSeller.price
            textViewOldPrice.text = bestSeller.oldPrice
            textViewOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

            if(bestSeller.isIsLiked){
                imageViewLike.setImageResource(R.drawable.ic_like)

            }else{
                imageViewLike.setImageResource(R.drawable.ic_menu_not_like)

            }
        }
//        fun addListener(bestSellerMenu: BestSellerMenu){
//            BHLike.onNext(bestSellerMenu)
//        }
    }

}