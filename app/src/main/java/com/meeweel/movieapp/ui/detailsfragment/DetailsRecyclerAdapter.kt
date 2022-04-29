package com.meeweel.movieapp.ui.detailsfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meeweel.movieapp.databinding.CastRecyclerItemBinding
import com.meeweel.movieapp.databinding.MainRecyclerItemBinding

class DetailsRecyclerAdapter :
    RecyclerView.Adapter<DetailsRecyclerAdapter.MainViewHolder>() {

    private var filmData: List<String> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = CastRecyclerItemBinding.inflate(
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

    inner class MainViewHolder(private val binding: CastRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: String) {
            binding.apply {
                title.text = person
            }
        }
    }

    fun setData(data: List<String>) {
        filmData = data
        notifyDataSetChanged()
    }
}