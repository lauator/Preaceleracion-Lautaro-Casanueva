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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailDialogFragment : DialogFragment() {


    private val detailViewModel: DetailViewModel by viewModels()

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

        detailViewModel.error.observe(viewLifecycleOwner, Observer<String>{error ->
            if(error != null){
                binding.tvTitle.text = error
            }

        })





    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

    }


}