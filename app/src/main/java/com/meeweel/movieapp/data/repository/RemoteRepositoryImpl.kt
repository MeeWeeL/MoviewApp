package com.meeweel.movieapp.data.repository

import com.meeweel.movieapp.data.network.ApiService
import com.meeweel.movieapp.domain.Converter
import com.meeweel.movieapp.domain.Film
import io.reactivex.rxjava3.core.Single

class RemoteRepositoryImpl(private val repo: ApiService) : Repository {
    override fun getFilms(): Single<List<Film>> {
        return repo.getFilms().map {
            Converter.convertResponseToFilms(it.results)
        }
    }
}