package com.example.cinemapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemapp.databinding.ActivityMainBinding
import com.example.cinemapp.models.Movie
import com.example.cinemapp.models.MovieResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private val moviesList = mutableListOf<Movie>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPopularMovies()

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = MovieAdapter(moviesList)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter

    }

    private fun getRetrofit():Retrofit{
       return Retrofit.Builder()
           .baseUrl("https://api.themoviedb.org/3/movie/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }

    private fun getPopularMovies(){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<MovieResponse> = getRetrofit().create(APIService::class.java).getPopularMovies()
            val response: MovieResponse? = call.body()

            runOnUiThread {
                if(call.isSuccessful){

                    val movies: List<Movie> = response?.results ?: emptyList()


                    moviesList.clear()
                    moviesList.addAll(movies)
                    adapter.notifyDataSetChanged()

                }else{
                    showError()

                }
            }


        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}