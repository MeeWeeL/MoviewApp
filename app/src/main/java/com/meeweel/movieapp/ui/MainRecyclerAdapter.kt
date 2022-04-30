package com.meeweel.movieapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meeweel.movieapp.R
import com.meeweel.movieapp.domain.Film
import com.meeweel.movieapp.databinding.MainRecyclerItemBinding

class MainRecyclerAdapter :
    RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {

    private var filmData: List<Film> = listOf()
    private var onItemViewClickListener: MainScreenFragment.OnItemViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = MainRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(filmData[position])
    }

    override fun getItemCount(): Int {
        return filmData.size
    }

    inner class MainViewHolder(private val binding: MainRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(film: Film) {
            binding.apply {
                title.text = film.title
                date.text = film.year
                Glide.with(binding.poster.context)
                    .load(film.image)
                    .error(R.drawable.default_background)
                    .placeholder(R.drawable.default_poster)
                    .into(this.poster)

                root.setOnClickListener {
                    onItemViewClickListener?.onItemViewClick(film)
                }
            }
        }
    }

    fun setOnItemViewClickListener(onItemViewClickListener: MainScreenFragment.OnItemViewClickListener) {
        this.onItemViewClickListener = onItemViewClickListener
    }

    fun removeOnItemViewClickListener() {
        onItemViewClickListener = null
    }

    fun setData(data: List<Film>) {
        filmData = data
        notifyDataSetChanged()
    }
}