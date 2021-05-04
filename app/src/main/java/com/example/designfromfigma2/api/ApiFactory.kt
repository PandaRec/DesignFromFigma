package com.example.designfromfigma2.api

import com.example.designfromfigma2.pojo.BestSellerMenu
import com.example.designfromfigma2.pojo.CartItem
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiFactory {
    @GET("phones")
    fun getPhones():Observable<List<BestSellerMenu>>

    @GET("cart")
    fun getCart():Observable<List<CartItem>>
}