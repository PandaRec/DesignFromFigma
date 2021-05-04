package com.example.designfromfigma2.ui.details

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.designfromfigma2.R
import com.example.designfromfigma2.api.ApiService
import com.example.designfromfigma2.pojo.CartItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel: ViewModel() {

    fun getListOfImages():List<Int>{
        val list = mutableListOf<Int>()
        list.add(R.drawable.phone_left)
        list.add(R.drawable.samsung_note_20)
        list.add(R.drawable.phone_right)
        return list
    }

    fun insertToCart(price:String,title:String,imageURL:String,id:Int,context:Context,count:Int=1){

        ApiService.api.insertItemToCart(price,title,imageURL,count,id).enqueue(object : Callback<CartItem> {
            override fun onResponse(call: Call<CartItem>, response: Response<CartItem>) {
                //Log.i("TAG2", "post submitted to API." + response.body()!!)

                if (response.isSuccessful) {
                    Toast.makeText(context,"успешно добавлено в корзину",Toast.LENGTH_SHORT).show()

                    Log.i("TAG2", "post result" + response.body()!!.toString())

                }
            }

            override fun onFailure(call: Call<CartItem>, t: Throwable) {
                Log.d("TAG2","insert to cart error: ${t.message.toString()}")
                Toast.makeText(context,"Ошибка при добавлении в корзину",Toast.LENGTH_SHORT).show()

            }
        })

    }
}