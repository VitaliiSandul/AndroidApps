package com.example.dz_20210405_marvelapp.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_20210405_marvelapp.R
import com.example.dz_20210405_marvelapp.adapters.ComicAdapter
import com.example.dz_20210405_marvelapp.databinding.FragmentItemMarvelBinding
import com.example.dz_20210405_marvelapp.viewmodels.ItemMarvelViewModel
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ItemMarvelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemMarvelFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var itemId: Int? = null
    private lateinit var itemName: String
    private lateinit var itemUrl: String

    private lateinit var binding: FragmentItemMarvelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            itemId = it.getString("itemId")?.toInt()
            itemName = it.getString("itemName").toString()
            itemUrl = it.getString("itemUrl").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_marvel, container,false)
        val itemMarvelViewModel = ViewModelProvider(this).get(ItemMarvelViewModel::class.java)
        itemMarvelViewModel.loadComicsByCharacterId(itemId.toString())

        binding.viewModel = itemMarvelViewModel

        val comicRecyclerView : RecyclerView = binding.root.findViewById(R.id.comicRecyclerView)
        comicRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        itemMarvelViewModel.comicsList.observe(viewLifecycleOwner, Observer {
            comicRecyclerView.adapter = ComicAdapter(it)
        })


        val nameHero :TextView = binding.root.findViewById(R.id.nameHero)
        nameHero.text = itemName

        val imageHero : ImageView = binding.root.findViewById(R.id.imageHero)
        Picasso.get().load(Uri.parse(itemUrl))
            .into(imageHero)

        val listEmpty :TextView = binding.root.findViewById(R.id.listEmpty)

        if(itemMarvelViewModel.comicsListSize.value == 0){
            listEmpty.text = "No comics!!!"
        }

        itemMarvelViewModel.comicsListSize.observe(viewLifecycleOwner, Observer {
            if(itemMarvelViewModel.comicsListSize.value != 0){
                listEmpty.text = ""
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
         * @return A new instance of fragment ItemMarvelFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ItemMarvelFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}