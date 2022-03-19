package com.example.mymovies.data.repository.repositoryInterface

import com.example.mymovies.data.model.latestMovies.LatestMovieResponse
import retrofit2.Response

interface LatestMovieRepo {

    suspend fun saveLatestMovieToDb(latestMovie:LatestMovieResponse)

    suspend fun getLatestMovie(token: String): Response<LatestMovieResponse>

    suspend fun getLatestMovieFromDb(): LatestMovieResponse
}