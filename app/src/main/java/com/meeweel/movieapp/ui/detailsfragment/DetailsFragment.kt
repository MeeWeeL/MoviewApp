package com.meeweel.movieapp.ui.detailsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.meeweel.movieapp.databinding.DetailsScreenLayoutBinding
import com.meeweel.movieapp.domain.Film
import com.meeweel.movieapp.ui.MainRecyclerAdapter
import com.meeweel.movieapp.ui.MainViewModel

class DetailsFragment : Fragment() {

    private var _binding: DetailsScreenLayoutBinding? = null
    private val binding get() = _binding!!
    private val adapter = DetailsRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsScreenLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainFragmentRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mainFragmentRecyclerView.adapter = adapter
        arguments?.getParcelable<Film>(BUNDLE_EXTRA)?.let { film ->
            adapter.setData(film.actors)
        }
    }

    companion object {
        const val BUNDLE_EXTRA = "FILM_ID"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}