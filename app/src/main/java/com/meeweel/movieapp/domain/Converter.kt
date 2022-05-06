package com.meeweel.movieapp.domain

object Converter {

    fun convertResponseToFilms(resp: List<FilmsResponse>) : List<Film> = resp.map { convertResponseToFilm(it) }

    private fun convertResponseToFilm(resp: FilmsResponse) : Film = Film(
        resp._id,
        resp.image,
        resp.title,
        resp.rating,
        resp.release,
        resp.description,
        convertGenres(resp.genres),
        convertActors(resp.actors)
    )

    private fun convertGenres(genres: List<GenreResponse>) : List<String> = genres.map { it.name }

    private fun convertActors(actors: List<ActorResponse>) : List<String> = actors.map { it.name }
}