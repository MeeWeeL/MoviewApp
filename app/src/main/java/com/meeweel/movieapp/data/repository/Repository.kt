package com.meeweel.movieapp.data.repository

import com.meeweel.movieapp.domain.Film
import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getFilms() : Single<List<Film>>
}