package com.meeweel.movieapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val id: String,
    val image: String,
    val title: String,
    val rating: String,
    val year: String,
    val description: String,
    val genres: List<String>,
    val actors: List<String>
) : Parcelable