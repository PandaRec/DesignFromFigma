package com.example.designfromfigma2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designfromfigma2.MainActivity
import com.example.designfromfigma2.R
import com.example.designfromfigma2.adapters.BestSellerAdapter
import com.example.designfromfigma2.adapters.CategoryAdapter
import com.example.designfromfigma2.adapters.HotSaleAdapter
import com.example.designfromfigma2.ui.filter.FilterFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.top_of_home_layout.view.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var parentActivity: MainActivity

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val navController = NavHostFragment.findNavController(this)
        parentActivity = activity as MainActivity
        if(parentActivity.bottomNavigationView?.visibility==View.GONE){
        parentActivity.bottomNavigationView?.visibility=View.VISIBLE
        }

        val spinnerGeo = root.spinnerGeo
        val adapterGeo = ArrayAdapter.createFromResource(requireContext(),R.array.testArrayForSpinner,R.layout.spinner_geo_item)
        spinnerGeo.adapter = adapterGeo





        val recyclerViewCategory = root.recyclerViewCategory
        val adapterRecyclerView = CategoryAdapter()

        initializeCategory(recyclerViewCategory,adapterRecyclerView)

        adapterRecyclerView.onCategoryClickListener = object : CategoryAdapter.OnCategoryClickListener{
            override fun onCategoryClick(position: Int) {
                val tempList = adapterRecyclerView.listOfIdOfCategories
                tempList[position].isPressed = true
                adapterRecyclerView.listOfIdOfCategories = tempList
            }
        }

        val recyclerViewHotSale = root.recyclerViewHotSale
        val adapterHotSale = HotSaleAdapter()
        initializeHotSale(recyclerViewHotSale,adapterHotSale)


        val recyclerViewBestSaller = root.recyclerViewBestSeller
        val adapterBestSeller = BestSellerAdapter()
        initializeBestSeller(recyclerViewBestSaller,adapterBestSeller)


        adapterBestSeller.onItemClickListener =object :BestSellerAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val current = adapterBestSeller.someList[position]

                navController.navigate(HomeFragmentDirections.actionNavigationHomeToNavigationDetails(
                        current.id,
                        current._id,
                    current.fullTitle,
                    current.rating,
                    current.processor,
                    current.camera,
                    current.ram,
                    current.rom,
                    current.price,
                        current.image

                )
                )

            }
        }

        root.ic_filter.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                val fragmentManager = childFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()

                val filterFragment = FilterFragment()
                fragmentTransaction.add(R.id.frameLayout,filterFragment).commit()

                //val parentActivity = activity as MainActivity
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

    private fun initializeCategory(recyclerViewCategory: RecyclerView, adapter:CategoryAdapter ){
        adapter.listOfIdOfCategories = homeViewModel.getTestValuesToCategoryMenu()
        recyclerViewCategory.adapter = adapter
    }
    private fun initializeHotSale(recyclerViewHotSale: RecyclerView, adapterHotSale:HotSaleAdapter){
        adapterHotSale.someList = listOf(R.drawable.hot_sale_new_2)
        recyclerViewHotSale.adapter = adapterHotSale
    }

    private fun initializeBestSeller(recyclerViewBestSaller: RecyclerView, adapterBestSeller:BestSellerAdapter){
        homeViewModel.getPhones().subscribe({
            adapterBestSeller.someList = it
            recyclerViewBestSaller.layoutManager = GridLayoutManager(context,2)
            recyclerViewBestSaller.adapter = adapterBestSeller
        },{
            Log.d("TAG",it.message.toString())
        })
        //todo: wrong place to download data. Need place where data do not destroy while fragment alive
        //todo: add compositeDisposable and override onDestroy

    }

}