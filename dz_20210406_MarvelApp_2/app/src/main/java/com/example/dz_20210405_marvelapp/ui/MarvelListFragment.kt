package com.example.dz_20210405_marvelapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_20210405_marvelapp.MainActivity
import com.example.dz_20210405_marvelapp.R
import com.example.dz_20210405_marvelapp.adapters.MarvelAdapter
import com.example.dz_20210405_marvelapp.databinding.FragmentMarvelListBinding
import com.example.dz_20210405_marvelapp.viewmodels.MarvelListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private var ARG_PARAM3 = "0"
/**
 * A simple [Fragment] subclass.
 * Use the [MarvelListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MarvelListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentMarvelListBinding
    private var offset: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            offset = it.getString(ARG_PARAM3)!!.toInt()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_marvel_list, container,false)
        val marvelViewModel = ViewModelProvider(this).get(MarvelListViewModel::class.java)
        binding.viewModel = marvelViewModel

        val marvelRecyclerView : RecyclerView = binding.root.findViewById(R.id.marvelRecyclerView)
        marvelRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        marvelViewModel.charactersList.observe(viewLifecycleOwner, Observer {
            marvelRecyclerView.adapter = MarvelAdapter(it)
        })

        marvelRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(-1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Log.d("-----", "up")
                    offset -= 20
                    if(offset < 0){
                        offset = marvelViewModel.totalHeros - marvelViewModel.totalHeros % 20
                    }
                    marvelViewModel.loadCharactersOffset(offset)
                }

                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Log.d("-----", "down")
                    offset += 20
                    if(offset > marvelViewModel.totalHeros){
                        offset = 0
                    }
                    marvelViewModel.loadCharactersOffset(offset)
                }
            }
        })

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MarvelListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MarvelListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, offset.toString())
                }
            }
    }
}