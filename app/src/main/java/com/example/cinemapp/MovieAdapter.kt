package com.example.cinemapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemapp.databinding.ItemMovieBinding
import com.example.cinemapp.models.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(val homeListener: HomeListener): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movies = ArrayList<Movie>()

    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ItemMovieBinding.bind(view)

        fun bind(movie: Movie){
            val query = "https://image.tmdb.org/t/p/original/${movie.poster_path}"
            Picasso.get().load(query).into(binding.ivMovie)
            binding.tvTitle.text = movie.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movies[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            homeListener.onMovieClicked(item.id)

        }
    }

    override fun getItemCount(): Int = movies.size


    fun updateData(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

}