package com.example.kotlindeepdive.paging

import com.example.kotlindeepdive.paging.data.MovieResponseDto
import com.example.kotlindeepdive.paging.data.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    companion object {
        const val SERVER_URL = "https://api.themoviedb.org/3"
        const val API_URL = "$SERVER_URL/movie/"
    }

    @GET("popular")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("page") pageNumber: Int
    ): ResponseDto<List<MovieResponseDto>>
}