package com.bignerdranch.android.photogallery

import com.bignerdranch.android.photogallery.api.MovieApi
import com.bignerdranch.android.photogallery.api.MovieItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MovieRepository {
    private val movieApi: MovieApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com//")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        movieApi = retrofit.create()
    }

    suspend fun fetchMovies(search: String, format: String): List<MovieItem> =
        movieApi.fetchMovies(search, format).movieItems
}
