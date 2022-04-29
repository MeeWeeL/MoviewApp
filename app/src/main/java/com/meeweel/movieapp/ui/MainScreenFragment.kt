package com.meeweel.movieapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.meeweel.movieapp.databinding.MainScreenLayoutBinding

class MainScreenFragment : Fragment() {

    private var _binding: MainScreenLayoutBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private val adapter = MainRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainScreenLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.mainFragmentRecyclerView.adapter = adapter

        val observer = Observer<MainAppState> {
            renderData(it)
        }
        viewModel.getData().observe(viewLifecycleOwner, observer)
        viewModel.requestFilms()
    }

    private fun renderData(data: MainAppState) = when (data) {
        is MainAppState.Success -> {
            val dataList = data.dataList
            binding.loadingLayout.visibility = View.GONE
            adapter.setData(dataList)
        }
        is MainAppState.Loading -> {
            binding.loadingLayout.visibility = View.VISIBLE
        }
        is MainAppState.Error -> {
            binding.loadingLayout.visibility = View.GONE

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}