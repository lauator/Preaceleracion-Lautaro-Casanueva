package com.example.cinemapp.views.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemapp.CinemApp
import com.example.cinemapp.R
import com.example.cinemapp.databinding.FragmentHomeBinding
import com.example.cinemapp.data.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: HomeViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.load()


        movieAdapter = MovieAdapter(this)


        binding.rvMovies.apply {

            layoutManager = LinearLayoutManager(view.context)
            adapter = movieAdapter

        }





        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.listMovie.observe(viewLifecycleOwner, Observer<List<Movie>> { movies ->

            if(movies != null){
                movieAdapter.updateData(movies)
            }

        })

        viewModel.error.observe(viewLifecycleOwner, Observer<String>{error ->

            if(error != null){
                binding.tvError.text = error
            }
        })




    }

    override fun onMovieClicked(id: Int) {
        val bundle = bundleOf("id" to id)
        findNavController().navigate(R.id.detailDialogFragment, bundle)
    }




}








