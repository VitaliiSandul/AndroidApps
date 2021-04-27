package com.example.dz_20210405_marvelapp

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var marvelRecyclerView : RecyclerView
    lateinit var marvelAdapter: MarvelAdapter
    var rowsArrayList: ArrayList<Character> = ArrayList()
    var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        marvelRecyclerView = findViewById(R.id.marvelRecyclerView)
        var layoutManager = LinearLayoutManager(this)
        marvelRecyclerView.setLayoutManager(layoutManager)

        populateData()
        initAdapter()
        initScrollListener()




        //marvelRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun initAdapter() {
        marvelAdapter = MarvelAdapter(rowsArrayList)
        marvelRecyclerView.setAdapter(marvelAdapter)
    }


    private fun populateData(){
        val service = RetrofitService()
                .getInstance()?.getCharacters()?.enqueue(object: Callback<ArrayList<Character>> {
                    override fun onFailure(call: Call<ArrayList<Character>>, t: Throwable) {
                        Log.d("MARVEL", t.localizedMessage)
                    }

                    override fun onResponse(
                            call: Call<ArrayList<Character>>,
                            response: Response<ArrayList<Character>>
                    ) {
                        marvelRecyclerView.adapter = response.body()?.let {
                            MarvelAdapter(it)
                        }
                        marvelRecyclerView.adapter?.notifyDataSetChanged()
                    }

                })
    }

    private fun initScrollListener() {
        marvelRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == rowsArrayList.size - 1) {
                        //bottom of list!



                        loadMore()
                        isLoading = true
                    }
                }
            }
        })
    }


    private fun loadMore() {
        rowsArrayList.add(Character("",""))
        marvelAdapter.notifyItemInserted(rowsArrayList.size - 1)
        val handler = Handler()
        handler.postDelayed(Runnable {
            rowsArrayList.removeAt(rowsArrayList.size - 1)
            val scrollPosition: Int = rowsArrayList.size
            marvelAdapter.notifyItemRemoved(scrollPosition)
            var currentSize = scrollPosition
            val nextLimit = currentSize + 20


            populateData()

            marvelAdapter.notifyDataSetChanged()
            isLoading = false
        }, 2000)
    }



}