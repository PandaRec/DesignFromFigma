package com.example.designfromfigma2.ui.home

import android.graphics.PorterDuff
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.designfromfigma2.R
import com.example.designfromfigma2.adapters.CategoryAdapter
import com.example.designfromfigma2.pojo.CategoryItemMenu
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val spinner = root.spinnerGeo
        val adapter = ArrayAdapter.createFromResource(requireContext(),R.array.testArrayForSpinner,R.layout.spinner_item)
        spinner.adapter = adapter

        val recyclerViewCategory = root.recyclerViewCategory
        val adapterRecyclerView = CategoryAdapter()

        adapterRecyclerView.listOfIdOfCategories = homeViewModel.getTestValuesToCategoryMenu()
        recyclerViewCategory.adapter = adapterRecyclerView

        adapterRecyclerView.onCategoryClickListener = object : CategoryAdapter.OnCategoryClickListener{
            override fun onCategoryClick(position: Int) {
                val tempList = adapterRecyclerView.listOfIdOfCategories
                tempList[position].isPressed = true
                adapterRecyclerView.listOfIdOfCategories = tempList
                //val tempList = adapterRecyclerView.listOfIdOfCategories
                //tempList[position].title = "lol"
                //adapterRecyclerView.listOfIdOfCategories = list
               // var a = context?.let { it.resources.getColor(R.color.orange) }

                //if (a != null) {
                    //holder.imageView.setBackgroundColor(a)
//                val tempList = adapterRecyclerView.listOfIdOfCategories
//                adapterRecyclerView.listOfIdOfCategories = tempList
//                        holder.imageView.setColorFilter(getResources().getColor(android.R.color.black))

                    //holder.imageView.setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_IN);

               // }

                Log.d("TAG","pressed")


            }
        }

        return root
    }
}