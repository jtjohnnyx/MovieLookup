package com.bignerdranch.android.photogallery.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "9b921434"

interface MovieApi {
    @GET("?apikey=$API_KEY")
    suspend fun fetchMovies(@Query("s") search: String, @Query("r") format: String): MovieResponse
}
