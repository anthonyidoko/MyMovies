package com.example.mymovies.data.repository.repositoryInterface

import androidx.lifecycle.LiveData
import com.example.mymovies.data.model.popularMovies.PopularMovies
import com.example.mymovies.data.model.popularMovies.PopularMoviesResult
import retrofit2.Response

interface PopularMoviesRepo {

    suspend fun fetchPopularMovies(token: String): Response<PopularMovies>

    suspend fun getPopularMoviesFromDb(): List<PopularMoviesResult>

    suspend fun savePopularMoviesToDb(movies: List<PopularMoviesResult>)
}