package com.example.designfromfigma2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.designfromfigma2.MainActivity
import com.example.designfromfigma2.R
import com.example.designfromfigma2.adapters.BestSellerAdapter
import com.example.designfromfigma2.adapters.CategoryAdapter
import com.example.designfromfigma2.adapters.HotSaleAdapter
import com.example.designfromfigma2.ui.filter.FilterFragment
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
        val navController = NavHostFragment.findNavController(this)


        //                navController.navigate(R.id.navigation_details)
        val spinnerGeo = root.spinnerGeo
        val adapterGeo = ArrayAdapter.createFromResource(requireContext(),R.array.testArrayForSpinner,R.layout.spinner_geo_item)
        spinnerGeo.adapter = adapterGeo





        val recyclerViewCategory = root.recyclerViewCategory
        val adapterRecyclerView = CategoryAdapter()

        adapterRecyclerView.listOfIdOfCategories = homeViewModel.getTestValuesToCategoryMenu()
        recyclerViewCategory.adapter = adapterRecyclerView

        adapterRecyclerView.onCategoryClickListener = object : CategoryAdapter.OnCategoryClickListener{
            override fun onCategoryClick(position: Int) {
                val tempList = adapterRecyclerView.listOfIdOfCategories
                tempList[position].isPressed = true
                adapterRecyclerView.listOfIdOfCategories = tempList
            }
        }

        val recyclerViewHotSale = root.recyclerViewHotSale
        val adapterHotSale = HotSaleAdapter()
        adapterHotSale.someList = listOf(R.drawable.hot_sale_new_2)
        recyclerViewHotSale.adapter = adapterHotSale


        val recyclerViewBestSaller = root.recyclerViewBestSeller
        val adapterBestSeller = BestSellerAdapter()
        adapterBestSeller.someList = homeViewModel.getTestValuesToBestSeller()
        recyclerViewBestSaller.layoutManager = GridLayoutManager(context,2)

        recyclerViewBestSaller.adapter = adapterBestSeller



        adapterBestSeller.onLikeClickListener = object : BestSellerAdapter.OnLikeClickListener{
            override fun onLikeClick(position: Int) {
                val tempList = adapterBestSeller.someList
                tempList[position].isLiked = !tempList[position].isLiked
                adapterBestSeller.someList = tempList
            }
        }
        adapterBestSeller.onItemClickListener =object :BestSellerAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val current = adapterBestSeller.someList[position]

                navController.navigate(HomeFragmentDirections.actionNavigationHomeToNavigationDetails(
                    current.fullTitle,
                    current.rating,
                    current.processor,
                    current.camera,
                    current.ram,
                    current.rom,
                    current.price
                )
                )


                //navController.navigate(R.id.navigation_details)
//                navController.navigate(HomeFragmentDirections.actionNavigationHomeToNavigationDetails(
//                    "",0,"","","","",""))
            }
        }

        root.ic_filter.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                val fragmentManager = childFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()

                val filterFragment = FilterFragment()
                fragmentTransaction.add(R.id.frameLayout,filterFragment).commit()

                val parentActivity = activity as MainActivity
                val bottomNavigationView = parentActivity.bottomNavigationView
                bottomNavigationView?.visibility = View.GONE

                val bot = recyclerViewHotSale.bottom

                frameLayout.startAnimation(TranslateAnimation(0f, 0f,
                    bot.toFloat(), 0f)
                    .apply {
                        duration = 2000
                    })

                frameLayout.visibility = View.VISIBLE


            }
        })





        return root
    }


}


