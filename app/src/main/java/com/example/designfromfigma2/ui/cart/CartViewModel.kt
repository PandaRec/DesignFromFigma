package com.example.designfromfigma2.ui.cart

import androidx.lifecycle.ViewModel
import com.example.designfromfigma2.api.ApiService
import com.example.designfromfigma2.pojo.BestSellerMenu
import com.example.designfromfigma2.pojo.CartItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CartViewModel: ViewModel() {

    fun getCart():Observable<List<CartItem>>{
        return ApiService.api.getCart()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}