package com.example.mymovies.data.repository.repositoryImpl

import androidx.lifecycle.LiveData
import com.example.mymovies.data.MovieService
import com.example.mymovies.data.db.MovieDatabase
import com.example.mymovies.data.model.popularMovies.PopularMovies
import com.example.mymovies.data.model.popularMovies.PopularMoviesResult
import com.example.mymovies.data.repository.repositoryInterface.PopularMoviesRepo
import retrofit2.Response
import javax.inject.Inject

class PopularMovieRepoImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDatabase: MovieDatabase
): PopularMoviesRepo {

    override suspend fun fetchPopularMovies(token: String): Response<PopularMovies> {
        return movieService.getPopularMovies(token)
    }

    override suspend fun getPopularMoviesFromDb(): List<PopularMoviesResult> {
        return movieDatabase.popularMoviesDao().getPopularMoviesFromDb()
    }

    override suspend fun savePopularMoviesToDb(movies: List<PopularMoviesResult>) {
        movieDatabase.popularMoviesDao().savePopularMoviesToDb(movies)
    }
}