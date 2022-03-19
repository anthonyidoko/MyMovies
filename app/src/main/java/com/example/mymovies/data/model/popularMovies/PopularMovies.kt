package com.example.mymovies.data.model.popularMovies

data class PopularMovies(
    val page: Int,
    val results: List<PopularMoviesResult>,
    val total_pages: Int,
    val total_results: Int
)