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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

    fun updateLikeInPhone(_id:String,isLiked:Boolean){
        ApiService.api.updateLikeInPhone(_id,isLiked).enqueue(object :Callback<BestSellerMenu>{
            override fun onResponse(call: Call<BestSellerMenu>, response: Response<BestSellerMenu>) {
                if (response.isSuccessful) {

                    Log.i("TAG2", "patch result" + response.body()!!.toString())

                }
            }

            override fun onFailure(call: Call<BestSellerMenu>, t: Throwable) {
                Log.d("TAG2","update like error: ${t.message.toString()}")
            }
        })
    }


}