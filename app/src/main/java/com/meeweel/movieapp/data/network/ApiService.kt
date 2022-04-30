package com.meeweel.movieapp.data.network

import com.meeweel.movieapp.domain.ApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("api/movies?")
    @Headers("Content-type: application/json")
    fun getFilms(@Query("type") type: String = "movies", @Query("sort") sort: String = "rating"): Single<ApiResponse> // @Query добавляет в запрос &id=$id

}