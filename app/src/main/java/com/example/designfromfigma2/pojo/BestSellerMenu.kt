package com.example.designfromfigma2.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class BestSellerMenu (
    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @SerializedName("price")
    @Expose
    var price: String = "",

    @SerializedName("oldPrice")
    @Expose
    var oldPrice: String = "",

    @SerializedName("fullTitle")
    @Expose
    var fullTitle: String = "",

    @SerializedName("image")
    @Expose
    var image: String = "",

    @SerializedName("isLiked")
    @Expose
    var isIsLiked: Boolean = false,

    @SerializedName("processor")
    @Expose
    var processor: String = "",

    @SerializedName("rating")
    @Expose
    var rating: Int = 0,

    @SerializedName("camera")
    @Expose
    var camera: String = "",

    @SerializedName("ram")
    @Expose
    var ram: String = "",

    @SerializedName("rom")
    @Expose
    var rom: String = "",
    @SerializedName("_id")
    @Expose
    var _id: String = ""



)