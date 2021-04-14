package com.example.designfromfigma2.adapters


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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.category_item,
            parent,
            false
        )
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val current = listOfIdOfCategories[position]
        holder.itemView.setOnClickListener { onCategoryClickListener?.onCategoryClick(position) }
        holder.insertToUI(current)
    }

    override fun getItemCount() = listOfIdOfCategories.size


    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageViewSub = itemView.imageViewSub
        val imageView = itemView.imageView
        val textViewTitle = itemView.textViewTitle

        fun insertToUI(categoryItem: CategoryItemMenu) {
            imageViewSub.setImageDrawable(
                ResourcesCompat.getDrawable(
                    itemView.context.resources,
                    categoryItem.imageId,
                    null
                )
            )
            textViewTitle.text = categoryItem.title
            if (categoryItem.isPressed) {
                val colorSub = itemView.context.resources.getColor(R.color.white)
                val color = itemView.context.resources.getColor(R.color.orange)
                imageViewSub.setColorFilter(colorSub)
                imageView.setColorFilter(color)
                textViewTitle.setTextAppearance(R.style.font_500_orange)
                categoryItem.isPressed = false

            } else {
                val colorSub = itemView.context.resources.getColor(R.color.gray)
                val color = itemView.context.resources.getColor(R.color.white)
                imageViewSub.setColorFilter(colorSub)
                imageView.setColorFilter(color)
                textViewTitle.setTextAppearance(R.style.font_500_dark_blue)

            }
        }
    }

    interface OnCategoryClickListener{
        fun onCategoryClick(position: Int)
    }
}