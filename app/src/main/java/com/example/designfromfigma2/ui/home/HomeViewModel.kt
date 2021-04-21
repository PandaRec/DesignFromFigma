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
        var item = CategoryItemMenu(R.drawable.ic_phones,R.string.phones,true)
        resultList.add(item)

        item = CategoryItemMenu(R.drawable.ic_computer,R.string.computer,false)
        resultList.add(item)

        item = CategoryItemMenu(R.drawable.ic_health,R.string.health,false)
        resultList.add(item)

        item = CategoryItemMenu(R.drawable.ic_books, R.string.books,false)
        resultList.add(item)

        item = CategoryItemMenu(R.drawable.ic_books, R.string.books,false)
        resultList.add(item)

        return resultList

    }

    fun getTestValuesToBestSeller(): List<BestSellerMenu>{
    val resultList = mutableListOf<BestSellerMenu>()

        var item = BestSellerMenu(R.string.samsung_galaxy_price,R.string.samsung_galaxy_old_price,R.string.samsung_galaxy_title,R.drawable.samsung_galaxy_s20_ultra_1,false,
            "Exynos 990",5,"108 + 12 mp","8 GB","256 GB")
        resultList.add(item)

        item = BestSellerMenu(R.string.xiaomi_price,R.string.xiaomi_old_price,R.string.xiaomi_title,R.drawable.xiaomi,true,
            "Exynos 990",4,"108 + 12 mp","4 GB","128 GB")
        resultList.add(item)

        item = BestSellerMenu(R.string.samsung_note_price,R.string.samsung_note_old_price,R.string.samsung_note_title,R.drawable.samsung_note_20,false,
            "Exynos 990",3,"108 + 12 mp","16 GB","64 GB")
        resultList.add(item)

        item = BestSellerMenu(R.string.motorola_price,R.string.motorola_old_price,R.string.motorola_title,R.drawable.motorola,false,
            "Exynos 990",2,"108 + 12 mp","2 GB","512 GB")
        resultList.add(item)

        return resultList
    }


}