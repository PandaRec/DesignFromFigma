package com.example.designfromfigma2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.R
import kotlinx.android.synthetic.main.hot_sales_item.view.*

class HotSaleAdapter: RecyclerView.Adapter<HotSaleAdapter.HotSaleViewHolder>() {
    var someList = listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSaleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hot_sales_item,parent,false)
        return HotSaleViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotSaleViewHolder, position: Int) {
        val current = someList[position]
        holder.insertToUI(current)

    }

    override fun getItemCount() = someList.size

    inner class HotSaleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageViewMain = itemView.mainImage

        fun insertToUI(hotSaleItemImgId:Int){
            imageViewMain.setImageDrawable(getDrawable(itemView.context.resources,hotSaleItemImgId,null))

        }
    }
}