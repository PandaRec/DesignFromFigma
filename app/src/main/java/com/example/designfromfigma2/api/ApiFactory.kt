package com.example.designfromfigma2.api

import com.example.designfromfigma2.pojo.BestSellerMenu
import com.example.designfromfigma2.pojo.CartItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiFactory {
    @GET("phones")
    fun getPhones():Observable<List<BestSellerMenu>>

    @GET("cart")
    fun getCart():Observable<List<CartItem>>
    @POST("cart")
    @FormUrlEncoded
    fun insertItemToCart(
            @Field("price") price:String,
            @Field("fullTitle") title: String,
            @Field("image") imageURL:String,
            @Field("counter") count:Int,
            @Field("id") id:Int
    ):Call<CartItem>
}