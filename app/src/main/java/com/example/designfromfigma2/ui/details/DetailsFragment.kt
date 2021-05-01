package com.example.designfromfigma2.ui.details

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.designfromfigma2.MainActivity
import com.example.designfromfigma2.R
import com.example.designfromfigma2.adapters.DetailsViewPagerAdapter
import com.example.designfromfigma2.ui.home.HomeFragmentDirections
import com.example.designfromfigma2.utils.HorizontalMarginItemDecoration
import kotlinx.android.synthetic.main.fragment_details.view.*
import java.lang.Math.abs

class DetailsFragment: Fragment() {
    private lateinit var detailsViewModel: DetailsViewModel
    private val args by navArgs<DetailsFragmentArgs>()
    private val title by lazy { args.title }
    private val rating by lazy { args.rating }
    private val processor by lazy { args.processor}
    private val camera by lazy { args.camera }
    private val ram by lazy { args.RAM }
    private val rom by lazy { args.ROM }
    private val price by lazy { args.price }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailsViewModel =
            ViewModelProvider(this).get(DetailsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_details, container, false)

        val viewPager = root.viewPager
        val detailsViewPagerAdapter = DetailsViewPagerAdapter()
        detailsViewPagerAdapter.listOfIdOfImages = detailsViewModel.getListOfImages()
        viewPager.adapter = detailsViewPagerAdapter


        viewPager.offscreenPageLimit = 1
        viewPager.setCurrentItem(1,false)


        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * abs(position))

        }
        viewPager.setPageTransformer(pageTransformer)


        context?.let {

            val itemDecoration = HorizontalMarginItemDecoration(
                it,
                R.dimen.viewpager_current_item_horizontal_margin
            )
            viewPager.addItemDecoration(itemDecoration)
        }

        val parentActivity = activity as MainActivity
        parentActivity.bottomNavigationView?.visibility=View.GONE

        root.titleDetails.setText(title)
        root.textViewProcessor.text = processor
        root.textViewCamera.text = camera
        root.textViewRAM.text = ram
        root.textViewROM.text = rom
        root.price.setText(price)
        root.ratingBar.rating = rating.toFloat()




        return root
    }
}