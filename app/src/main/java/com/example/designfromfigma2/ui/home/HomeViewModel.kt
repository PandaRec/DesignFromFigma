package com.example.designfromfigma2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.designfromfigma2.R
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


}