package com.example.mymovies.data.repository.repositoryInterface
import androidx.lifecycle.LiveData
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResponse
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResult
import retrofit2.Response

interface UpcomingMoviesRepo {

    suspend fun saveUpcomingMovieToDb(upcomingMovies: List<UpcomingMoviesResult>)

    suspend fun getUpcomingMovie(token: String): Response<UpcomingMoviesResponse>

    suspend fun getUpcomingMovieFromDb(): List<UpcomingMoviesResult>
}