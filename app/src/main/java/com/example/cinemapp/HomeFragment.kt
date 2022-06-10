package com.example.cinemapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemapp.databinding.FragmentHomeBinding
import com.example.cinemapp.models.Movie
import com.example.cinemapp.models.MovieResponse
import com.example.cinemapp.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


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

        viewModel.refresh()

        movieAdapter = MovieAdapter(this)


        binding.rvMovies.apply {
            //aca podria haber un error
            layoutManager = LinearLayoutManager(view.context)
            adapter = movieAdapter

        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.listMovie.observe(viewLifecycleOwner, Observer<List<Movie>>{ movies ->
            movieAdapter.updateData(movies)
        })

    }



    override fun onMovieClicked() {
        findNavController().navigate(R.id.detailDialogFragment)
    }


}