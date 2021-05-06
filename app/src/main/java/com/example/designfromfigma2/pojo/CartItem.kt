package com.example.designfromfigma2.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CartItem(
        @SerializedName("id")
        @Expose
        var id: Int = 0,
        @SerializedName("price")
        @Expose
        var price: String = "",
        @SerializedName("fullTitle")
        @Expose
        var fullTitle: String = "",
        @SerializedName("image")
        @Expose
        var image: String = "",
        @SerializedName("counter")
        @Expose
        var counter: Int = 0,
        @SerializedName("_id")
        @Expose
        var _id: String = ""
)