package com.example.designfromfigma2.api

import com.example.designfromfigma2.pojo.BestSellerMenu
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiFactory {
    @GET("phones")
    fun getPhones():Observable<List<BestSellerMenu>>
}