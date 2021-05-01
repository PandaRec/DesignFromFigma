package com.example.designfromfigma2.pojo

data class BestSellerMenu(
    val price:Int,
    val oldPrice:Int,
    val fullTitle:Int,
    val imageId:String,
    var isLiked:Boolean,
    val processor:String,
    val rating:Int,
    val camera:String,
    val ram:String,
    val rom:String)