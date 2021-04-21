package com.example.designfromfigma2.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.R
import com.example.designfromfigma2.pojo.CategoryItemMenu
import kotlinx.android.synthetic.main.category_item.view.*


class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){ // наследуемся от Adapter
    var onCategoryClickListener: OnCategoryClickListener?=null // переменная интерфейса
    var listOfIdOfCategories = listOf<CategoryItemMenu>() // пустой список
    set(value) { // переопределям сеттер
        field = value // установка значения
        notifyDataSetChanged() // подаем сигнал, что даныне изменились
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder { // переопределяем метод
        val view = LayoutInflater.from(parent.context).inflate( //устновка layout для элемента
            R.layout.category_item,
            parent,
            false
        )
        return CategoryViewHolder(view) // возвращаем CategoryViewHolder с View которыц связан с layout
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) { // переопеделяем метод
        val current = listOfIdOfCategories[position] // получаем элемент из списка относительно позиции адаптера (recyclerView?)
        holder.itemView.setOnClickListener { onCategoryClickListener?.onCategoryClick(position) } // установка слушателя нажатия на элемент
        holder.insertToUI(current) // вызов метода для устновки данных в конктреных элемент
    }

    override fun getItemCount() = listOfIdOfCategories.size // переопределяем метод. возвращаем размер списка


    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) { // вложенный класс. Наслжеуемся от ViewHolder
        val imageViewSub = itemView.imageViewSub // присваиваем переменноц элемент из layout
        val imageView = itemView.imageView // присваиваем переменноц элемент из layout
        val textViewTitle = itemView.textViewTitle // присваиваем переменноц элемент из layout

        fun insertToUI(categoryItem: CategoryItemMenu) { // метод устновки занчений в элементы в layout
            imageViewSub.setImageResource(categoryItem.imageId) // установка картинки
//            imageViewSub.setImageDrawable(
//                ResourcesCompat.getDrawable(
//                    itemView.context.resources,
//                    categoryItem.imageId,
//                    null
//                )
//            )
            textViewTitle.setText(categoryItem.title) // устновка текста
            if (categoryItem.isPressed) { // проверка, нажата или нет кнопка лайка. Если да, то:
                val colorSub = itemView.context.resources.getColor(R.color.white) // получаем белый цвет
                val color = itemView.context.resources.getColor(R.color.orange) // получаем ораньжевый цвет
                imageViewSub.setColorFilter(colorSub) // перекрашиваем элемент в белый
                imageView.setColorFilter(color) // перекрашиваем элемент в рыжий
                textViewTitle.setTextAppearance(R.style.font_500_orange) // устнавлаиваем стиль текста
                categoryItem.isPressed = false // изменяем значения о нажатии

            } else { // если нет, то:
                val colorSub = itemView.context.resources.getColor(R.color.gray) // получаем серый цвет
                val color = itemView.context.resources.getColor(R.color.white) // получаем белый цвет
                imageViewSub.setColorFilter(colorSub) // перекрашиваем элемент в серый
                imageView.setColorFilter(color) // перекрашиваем элемент в белый
                textViewTitle.setTextAppearance(R.style.font_500_dark_blue) // устнавлаиваем стиль текста

            }
        }
    }

    interface OnCategoryClickListener{ // интерфейс
        fun onCategoryClick(position: Int) // метод интерфейса
    }
}