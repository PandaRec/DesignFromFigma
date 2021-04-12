package com.example.designfromfigma2.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.R
import kotlinx.android.synthetic.main.hot_sales_item.view.*

class HotSaleAdapter: RecyclerView.Adapter<HotSaleAdapter.HotSaleViewHolder>() {
    var context : Context? = null
    var someList = listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
            Log.d("TAG","pppp")
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSaleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hot_sales_item,parent,false)
        context = parent.context
        return HotSaleViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotSaleViewHolder, position: Int) {
        holder.imageViewMain.setImageDrawable(context?.let { ResourcesCompat.getDrawable(it.resources,someList[position],null) })

    }

    override fun getItemCount() = someList.size

    inner class HotSaleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageViewMain = itemView.mainImage
    }
}