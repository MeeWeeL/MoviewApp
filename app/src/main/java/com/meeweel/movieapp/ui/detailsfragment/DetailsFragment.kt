package com.meeweel.movieapp.ui.detailsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.meeweel.movieapp.R
import com.meeweel.movieapp.data.repository.FakeRepo
import com.meeweel.movieapp.databinding.DetailsScreenLayoutBinding
import com.meeweel.movieapp.domain.Film
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

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

        binding.mainFragmentRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mainFragmentRecyclerView.adapter = adapter

        val film = arguments?.getParcelable<Film>(BUNDLE_EXTRA)!!
        with(binding) {
//            adapter.setData(film.actors) API выдаёт список актёров пустым, поэтому сделаю заглушку из фейка
            FakeRepo().getFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ adapter.setData(it[0].actors) }, {})


            title.text = film.title
            score.text = film.rating
            description.text = film.description
            genre.text = film.genres.toString().removePrefix("[").removeSuffix("]")
            date.text = film.year
            Glide.with(binding.poster.context)
                .load(film.image)
                .error(R.drawable.default_background)
                .placeholder(R.drawable.default_poster)
                .into(this.poster)
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