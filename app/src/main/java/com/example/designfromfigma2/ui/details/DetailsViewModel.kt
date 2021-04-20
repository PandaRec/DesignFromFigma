package com.example.designfromfigma2.ui.details

import androidx.lifecycle.ViewModel
import com.example.designfromfigma2.R

class DetailsViewModel: ViewModel() {

    fun getListOfImages():List<Int>{
        val list = mutableListOf<Int>()

        list.add(R.drawable.samsung_note_20)
        list.add(R.drawable.samsung_galaxy_s20_ultra_1)
        list.add(R.drawable.motorola)
        list.add(R.drawable.xiaomi)
        return list
    }
}