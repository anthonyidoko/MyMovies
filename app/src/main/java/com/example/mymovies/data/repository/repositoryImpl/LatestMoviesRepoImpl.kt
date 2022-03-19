package com.example.mymovies.data.repository.repositoryImpl

import com.example.mymovies.data.MovieService
import com.example.mymovies.data.db.MovieDatabase
import com.example.mymovies.data.model.latestMovies.LatestMovieResponse
import com.example.mymovies.data.repository.repositoryInterface.LatestMovieRepo
import retrofit2.Response
import javax.inject.Inject

class LatestMoviesRepoImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDatabase: MovieDatabase
    ): LatestMovieRepo {

    override suspend fun saveLatestMovieToDb(latestMovie: LatestMovieResponse) {
        movieDatabase.latestMoviesDao().saveLatestMovieToDb(latestMovie)
    }

    override suspend fun getLatestMovie(token: String): Response<LatestMovieResponse> {
        return movieService.getLatestMovies(token)
    }

    override suspend fun getLatestMovieFromDb(): LatestMovieResponse {
        return movieDatabase.latestMoviesDao().fetchLatestMovieFromDb()
    }


}