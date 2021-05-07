package com.example.designfromfigma2.api

import com.example.designfromfigma2.pojo.BestSellerMenu
import com.example.designfromfigma2.pojo.CartItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*


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

    @PUT("cart/{idToFind}")
    @FormUrlEncoded
    fun updateItemIntoCart(
            @Path("idToFind") idToFind: String,
            @Field("price") price:String,
            @Field("fullTitle") title: String,
            @Field("image") imageURL:String,
            @Field("counter") count:Int,
            @Field("id") id:Int
    ):Call<CartItem>

    @DELETE("cart/{idToFind}")
    fun deleteItemFromCart(
            @Path("idToFind") idToDelete: String,

            ):Call<CartItem>

    @PATCH("phones/{idToFind}")
    @FormUrlEncoded
    fun updateLikeInPhone(
            @Path("idToFind") idToFind:String,
            @Field("isLiked") isLiked:Boolean
    ):Call<BestSellerMenu>
}