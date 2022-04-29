package com.meeweel.movieapp.domain

data class Film(
    val id: String,
    val image: String,
    val title: String,
    val rating: String,
    val year: Int,
    val description: String,
    val genres: List<String>
)