package com.example.designfromfigma2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.designfromfigma2.R
import com.example.designfromfigma2.pojo.BestSellerMenu
import com.example.designfromfigma2.pojo.CategoryItemMenu

class HomeViewModel : ViewModel() {

    fun getTestValuesToCategoryMenu():List<CategoryItemMenu>{
        val resultList = mutableListOf<CategoryItemMenu>()
        var item = CategoryItemMenu(R.drawable.ic_phones,"Phones",true)
        resultList.add(item)

        item = CategoryItemMenu(R.drawable.ic_computer,"Computer",false)
        resultList.add(item)

        item = CategoryItemMenu(R.drawable.ic_health,"Health",false)
        resultList.add(item)

        item = CategoryItemMenu(R.drawable.ic_books, "Books",false)
        resultList.add(item)

        item = CategoryItemMenu(R.drawable.ic_books, "Books",false)
        resultList.add(item)

        return resultList

    }

    fun getTestValuesToBestSeller(): List<BestSellerMenu>{
    val resultList = mutableListOf<BestSellerMenu>()

        var item = BestSellerMenu("\$1,047","\$1,500","Samsung Galaxy s20 Ultra",R.drawable.samsung_galaxy_s20_ultra_1,false)
        resultList.add(item)

        item = BestSellerMenu("\$300","\$400","Xiaomi Mi 10 Pro",R.drawable.xiaomi,true)
        resultList.add(item)

        item = BestSellerMenu("\$1,047","\$1,500","Samsung Note 20 Ultra",R.drawable.samsung_note_20,false)
        resultList.add(item)

        item = BestSellerMenu("\$300","\$400","Motorola One Edge",R.drawable.motorola,false)
        resultList.add(item)

        return resultList
    }


}