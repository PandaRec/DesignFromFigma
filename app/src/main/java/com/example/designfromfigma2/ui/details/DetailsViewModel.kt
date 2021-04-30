package com.example.designfromfigma2.ui.details

import androidx.lifecycle.ViewModel
import com.example.designfromfigma2.R

class DetailsViewModel: ViewModel() {

    fun getListOfImages():List<Int>{
        val list = mutableListOf<Int>()
        list.add(R.drawable.phone_left)
        list.add(R.drawable.samsung_note_20)
        list.add(R.drawable.phone_right)
        return list
    }
}