package com.example.designfromfigma2.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private const val BASE_URL ="https://ecomm-6b09.restdb.io/rest/"

    private val logger = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    //create okHttp client
    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(logger)


    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttp.apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("x-apikey","f986c83633e28d3afba3094e11a9add361b90")
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }.build()).build()

    val api = retrofit.create(ApiFactory::class.java)
}