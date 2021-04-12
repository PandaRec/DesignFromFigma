package com.example.designfromfigma2.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.R
import com.example.designfromfigma2.pojo.CategoryItemMenu
import kotlinx.android.synthetic.main.category_item.view.*


class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    var onCategoryClickListener: OnCategoryClickListener?=null
    var listOfIdOfCategories = listOf<CategoryItemMenu>()
    set(value) {
        field = value
        notifyDataSetChanged()
        Log.d("TAG","pppp")
    }
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.category_item,
            parent,
            false
        )
        context = parent.context
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val current = listOfIdOfCategories[position]

        holder.imageViewSub.setImageDrawable(context?.let { ResourcesCompat.getDrawable(it.resources,current.imageId,null) })
        holder.textViewTitle.text = current.title
        holder.itemView.setOnClickListener { onCategoryClickListener?.onCategoryClick(position) }

        if(current.isPressed){
            val colorSub = context?.let { it.getResources().getColor(R.color.white)}
            val color = context?.let { it.getResources().getColor(R.color.orange)}

            if (colorSub != null && color!=null) {
                holder.imageViewSub.setColorFilter(colorSub)
                holder.imageView.setColorFilter(color)
            }
            holder.textViewTitle.setTextAppearance(R.style.font_500_orange)

            current.isPressed = false

        }else{
            val colorSub = context?.let { it.getResources().getColor(R.color.gray)}
            val color = context?.let { it.getResources().getColor(R.color.white)}

            if (colorSub != null && color!=null) {
                holder.imageViewSub.setColorFilter(colorSub)
                holder.imageView.setColorFilter(color)

            }
            holder.textViewTitle.setTextAppearance(R.style.font_500_dark_blue)


        }

    }

    override fun getItemCount() = listOfIdOfCategories.size


    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageViewSub = itemView.imageViewSub
        val imageView = itemView.imageView
        val textViewTitle = itemView.textViewTitle
    }

    interface OnCategoryClickListener{
        fun onCategoryClick(position: Int)
    }
}