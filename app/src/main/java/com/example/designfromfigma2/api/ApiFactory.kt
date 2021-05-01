package com.example.designfromfigma2.api

import com.example.designfromfigma2.pojo.BestSellerMenu
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiFactory {
    //@Headers("x-apikey: f986c83633e28d3afba3094e11a9add361b90")
    @GET("phones")
    fun getPhones():Observable<List<BestSellerMenu>>
}