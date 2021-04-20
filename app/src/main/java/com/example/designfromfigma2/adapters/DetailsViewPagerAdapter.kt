package com.example.designfromfigma2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.R
import kotlinx.android.synthetic.main.view_pager_item.view.*

class DetailsViewPagerAdapter : RecyclerView.Adapter<DetailsViewPagerAdapter.DetailsViewHolder>() {
    var listOfIdOfImages = listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item,parent,false)
        return DetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val current = listOfIdOfImages[position]
        holder.insertToUi(current,position)
        //todo: при нормальных картинках убрать передачу позиции и изменить insertToUi
    }

    override fun getItemCount() = listOfIdOfImages.size

    inner class DetailsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imageView = itemView.imageViewViewPager
         fun insertToUi(imageId:Int,position: Int){
            imageView.setImageResource(imageId)
             when(position){
                 0 -> imageView.scaleType = ImageView.ScaleType.FIT_END
                 2 -> imageView.scaleType = ImageView.ScaleType.FIT_START
             }


        }
    }
}