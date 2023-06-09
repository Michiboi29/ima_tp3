package com.example.tp3.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tp3.MainActivity
import com.example.tp3.R
import com.example.tp3.dataClasses.Brand
import com.example.tp3.dataClasses.BrandLists
import com.example.tp3.ui.main.placeholder.PlaceholderContent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 */
class Offre1Fragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_offre1_list, container, false)
        getBrand()
        // Set the adapter
//        if (view is RecyclerView) {
//            with(view) {
//                layoutManager = when {
//                    columnCount <= 1 -> LinearLayoutManager(context)
//                    else -> GridLayoutManager(context, columnCount)
//                }
//                adapter = MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS)
//            }
//        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            Offre1Fragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    private val apiClient = ClientApi.buildService(InterfaceApi::class.java)
    private fun getBrand() {
        apiClient.listbrand().enqueue(object :
            Callback<BrandLists> {
            override fun onResponse(
                call: Call<BrandLists>,
                response: Response<BrandLists>
            ) {
                var contentList: List<Brand> = emptyList()
                Log.d("ima-tp3-response", "${response.body()}")
                response.body()?.let {
                    contentList = it.brands
                    Log.d("ima-tp3-response", "$contentList")
                }
                val context = context as MainActivity
                val rv = context.findViewById(R.id.recyclerView) as RecyclerView
                var position:Int?=null
                var brandi: Brand
                rv.adapter = MyItemRecyclerViewAdapter(contentList) {
                    position = it
                }

            }

            override fun onFailure(call: Call<BrandLists>, t: Throwable) {
                Log.e("ima-tp3", "get list brand failure $t")
            }
        }
        )
    }
}