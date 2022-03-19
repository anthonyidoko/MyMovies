package com.example.mymovies.data.repository.repositoryImpl

import com.example.mymovies.data.MovieService
import com.example.mymovies.data.repository.repositoryInterface.MovieDetailRepo
import javax.inject.Inject

class MovieDetailImpl @Inject constructor(private val movieService: MovieService): MovieDetailRepo {
}