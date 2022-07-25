package com.example.cinemapp.views.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.cinemapp.databinding.FragmentDetailDialogBinding


import com.squareup.picasso.Picasso


class DetailDialogFragment : DialogFragment() {


    private val detailViewModel: DetailViewModel by viewModels(
        factoryProducer = {DetailViewModelFactory()}
    )
    private var _binding: FragmentDetailDialogBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getSerializable("id") as Int

        //detailViewModel.getDetailMovie(id)
        detailViewModel.load(id)

        binding.apply {
            viewModel = detailViewModel
            lifecycleOwner = viewLifecycleOwner
            detailFragment = this@DetailDialogFragment

        }



        detailViewModel.image.observe(viewLifecycleOwner, Observer<String>{ image ->

            if(image.isNotEmpty()){
                Picasso.get().load(image).into(binding.ivMovie)
            }

        })

        if(detailViewModel.title.value == null){
            binding.tvTitle.text = "There was an error while trying to connect the API, please review your connection to Internet and try again"
        }

        if(detailViewModel.title.value != null && detailViewModel.overview.value == null){
            binding.tvOverview.text = "There is not overview for this movie"
        }



    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

    }


}