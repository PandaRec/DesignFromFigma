package com.example.designfromfigma2.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.designfromfigma2.MainActivity
import com.example.designfromfigma2.R
import kotlinx.android.synthetic.main.fragment_filter.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class FilterFragment : Fragment() {
    private lateinit var filterViewModel: FilerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        filterViewModel =
            ViewModelProvider(this).get(FilerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_filter, container, false)

        val spinnerBrand = root.spinnerBrand
        val adapterBrand = ArrayAdapter.createFromResource(requireContext(),R.array.testArrayForFilterBrand,R.layout.spinner_filter_item)
        spinnerBrand.adapter = adapterBrand

        val spinnerPrice = root.spinnerPrice
        val adapterPrice = ArrayAdapter.createFromResource(requireContext(),R.array.testArrayForFilterPrice,R.layout.spinner_filter_item)
        spinnerPrice.adapter = adapterPrice

        val spinnerSize = root.spinnerSize
        val adapterSize = ArrayAdapter.createFromResource(requireContext(),R.array.testArrayForFilterSize,R.layout.spinner_filter_item)
        spinnerSize.adapter = adapterSize

        root.exitRounded.setOnClickListener {
            val parentActivity = activity as MainActivity
            val myParentFragment = parentFragment

            hideFilter(myParentFragment)
            showBottomNavigation(parentActivity)

        }

        root.doneRounded.setOnClickListener {
            val parentActivity = activity as MainActivity
            val myParentFragment = parentFragment

            hideFilter(myParentFragment)
            showBottomNavigation(parentActivity)
        }




        return root
    }

    private fun hideFilter(fragment: Fragment?){
        fragment?.let {
            val bot = fragment.recyclerViewHotSale.bottom

            it.frameLayout.startAnimation(
                TranslateAnimation(0f, 0f,
                    0f, bot.toFloat())
                    .apply {
                        duration = 2000
                    })
            it.frameLayout.visibility = View.GONE
        }

    }

    private fun showBottomNavigation(mainActivity:MainActivity){
            mainActivity.bottomNavigationView?.visibility = View.VISIBLE
    }

}