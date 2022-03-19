package com.example.mymovies.data.repository.repositoryImpl

import androidx.lifecycle.LiveData
import com.example.mymovies.data.MovieService
import com.example.mymovies.data.db.MovieDatabase
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResponse
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResult
import com.example.mymovies.data.repository.repositoryInterface.UpcomingMoviesRepo
import retrofit2.Response
import javax.inject.Inject

class UpcomingMoviesRepoImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDatabase: MovieDatabase
): UpcomingMoviesRepo {
    override suspend fun saveUpcomingMovieToDb(upcomingMovies: List<UpcomingMoviesResult>) {
        movieDatabase.upcomingMoviesDao().saveUpcomingMoviesToDb(upcomingMovies)
    }

    override suspend fun getUpcomingMovie(token: String): Response<UpcomingMoviesResponse> {
        return movieService.getUpcomingMovies(token)
    }

    override suspend fun getUpcomingMovieFromDb(): List<UpcomingMoviesResult> {
        return movieDatabase.upcomingMoviesDao().getUpcomingMoviesFromDb()
    }
}