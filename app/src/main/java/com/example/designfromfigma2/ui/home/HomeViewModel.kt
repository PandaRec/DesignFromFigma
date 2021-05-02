package com.example.designfromfigma2.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.designfromfigma2.R
import com.example.designfromfigma2.api.ApiService
import com.example.designfromfigma2.pojo.BestSellerMenu
import com.example.designfromfigma2.pojo.CategoryItemMenu
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

    fun getPhones():Observable<List<BestSellerMenu>>{
        return ApiService.api.getPhones()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}