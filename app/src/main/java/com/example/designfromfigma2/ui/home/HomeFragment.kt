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


class HomeFragment : Fragment() { // наследуемся от Fragment (говорим о том, что теперь этот класс - фрагмент)

    private lateinit var homeViewModel: HomeViewModel // переменная типа HomeViewModel, котороя обязательно будет потом инициализирована

    override fun onCreateView( // метод отрисовки
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java) // присваем занчение перменной
        val root = inflater.inflate(R.layout.fragment_home, container, false) // связываем фрагмент с layout
        val navController = NavHostFragment.findNavController(this) // переменная для навигации


        val spinnerGeo = root.spinnerGeo // присваиваем переменной элемент из layout
        val adapterGeo = ArrayAdapter.createFromResource(requireContext(),R.array.testArrayForSpinner,R.layout.spinner_geo_item)// создаем адаптер из массива данных и элемента, который говорит как будет выглядеть строка в спинере
        spinnerGeo.adapter = adapterGeo // устанвливаем адаптер в спиннер





        val recyclerViewCategory = root.recyclerViewCategory // присваиваем переменной элемент из layout
        val adapterRecyclerView = CategoryAdapter() // создаем адаптер

        adapterRecyclerView.listOfIdOfCategories = homeViewModel.getTestValuesToCategoryMenu() // получаем данные и устанавливаем их в список в адаптере
        recyclerViewCategory.adapter = adapterRecyclerView // устаналиваем адаптер в recyclerView

        adapterRecyclerView.onCategoryClickListener = object : CategoryAdapter.OnCategoryClickListener{ // устновка слушателя клика
            override fun onCategoryClick(position: Int) { // переопределяем действие при сробатывании
                val tempList = adapterRecyclerView.listOfIdOfCategories // создаем временный список, который полная копия существующего ( костыль, но не знаю как тут устновить notifyDataSetChanged?)
                tempList[position].isPressed = true // изменяем значение
                adapterRecyclerView.listOfIdOfCategories = tempList // присваиваем измененный список в список в адаптере
            }
        }

        val recyclerViewHotSale = root.recyclerViewHotSale // присваиваем переменной элемент из layout
        val adapterHotSale = HotSaleAdapter() // создаем адаптер
        adapterHotSale.someList = listOf(R.drawable.hot_sale_new_2) // создаем список, присваиваем его в список который в адаптере
        recyclerViewHotSale.adapter = adapterHotSale // устаналиваем адаптер в recyclerView


        val recyclerViewBestSaller = root.recyclerViewBestSeller // присваиваем переменной элемент из layout
        val adapterBestSeller = BestSellerAdapter() // создаем адаптер
        adapterBestSeller.someList = homeViewModel.getTestValuesToBestSeller() // получаем данные и устанавливаем их в список в адаптере
        recyclerViewBestSaller.layoutManager = GridLayoutManager(context,2) // устаавливаем layoutManager для recyclerView (делаем две колонки)

        recyclerViewBestSaller.adapter = adapterBestSeller // устаналиваем адаптер в recyclerView



        adapterBestSeller.onLikeClickListener = object : BestSellerAdapter.OnLikeClickListener{ // устновка слушателя клика
            override fun onLikeClick(position: Int) { // переопределяем действие при сробатывании
                val tempList = adapterBestSeller.someList // создаем временный список, который полная копия существующего ( костыль, но не знаю как тут устновить notifyDataSetChanged?)
                tempList[position].isLiked = !tempList[position].isLiked // устанавливаем обратное значение
                adapterBestSeller.someList = tempList // присваиваем измененный список в список в адаптере
            }
        }
        adapterBestSeller.onItemClickListener =object :BestSellerAdapter.OnItemClickListener{ // устновка слушателя клика
            override fun onItemClick(position: Int) { // переопределяем действие при сробатывании
                val current = adapterBestSeller.someList[position] // получаем элемент на который кликнули

                navController.navigate(HomeFragmentDirections.actionNavigationHomeToNavigationDetails( // навигация на другой фрагмент с данными
                    current.fullTitle,
                    current.rating,
                    current.processor,
                    current.camera,
                    current.ram,
                    current.rom,
                    current.price
                )
                )

            }
        }

        root.ic_filter.setOnClickListener(object : View.OnClickListener{  // устновка слушателя клика
            override fun onClick(v: View?) { // переопределяем действие при сробатывании

                val fragmentManager = childFragmentManager // получаем приватный FragmentManager для упрвления фрагментом внутри этого фрагмента
                val fragmentTransaction = fragmentManager.beginTransaction() // открываем транзакцию

                val filterFragment = FilterFragment() // создаем переменную FilterFragment
                fragmentTransaction.add(R.id.frameLayout,filterFragment).commit() // устанавливаем конечныц пункт транзакии. Запускаем ее

                val parentActivity = activity as MainActivity // получаем родительскую активити
                val bottomNavigationView = parentActivity.bottomNavigationView // получаем из нее bottom navigation
                bottomNavigationView?.visibility = View.GONE // убираем bottom navigation

                val bot = recyclerViewHotSale.bottom // получаем нижнюю границу recyclerViewHotSale

                frameLayout.startAnimation(TranslateAnimation(0f, 0f, // анимауия для фрагмента фильтра
                    bot.toFloat(), 0f)
                    .apply {
                        duration = 2000
                    })

                frameLayout.visibility = View.VISIBLE // делаем фрагмент фильтра видимым


            }
        })





        return root // возвращаем объект типа View
    }


}


