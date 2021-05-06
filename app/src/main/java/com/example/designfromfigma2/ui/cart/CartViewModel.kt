package com.example.designfromfigma2.ui.cart

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.designfromfigma2.api.ApiService
import com.example.designfromfigma2.pojo.CartItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CartViewModel: ViewModel() {

    fun getCart():Observable<List<CartItem>>{
        return ApiService.api.getCart()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun updateCartItem(idToFind:String,price:String, title:String, imageURL:String, id:Int, count:Int=1){
        val newCount = if(count<1){
            1
        }else{
            count
        }

        ApiService.api.updateItemIntoCart(idToFind,price,title,imageURL,newCount,id).enqueue(object :Callback<CartItem>{
            override fun onResponse(call: Call<CartItem>, response: Response<CartItem>) {
                if (response.isSuccessful) {

                    Log.i("TAG2", "put result" + response.body()!!.toString())

                }
            }

            override fun onFailure(call: Call<CartItem>, t: Throwable) {
                Log.d("TAG2","update cart error: ${t.message.toString()}")
            }
        })
    }

    fun deleteItemFromCart(idToDelete:String){
        ApiService.api.deleteItemFromCart(idToDelete).enqueue(object :Callback<CartItem>{
            override fun onResponse(call: Call<CartItem>, response: Response<CartItem>) {
                if (response.isSuccessful) {

                    Log.i("TAG2", "put result" + response.body()!!.toString())

                }            }

            override fun onFailure(call: Call<CartItem>, t: Throwable) {
                Log.d("TAG2","update cart error: ${t.message.toString()}")
            }
        })
    }
}