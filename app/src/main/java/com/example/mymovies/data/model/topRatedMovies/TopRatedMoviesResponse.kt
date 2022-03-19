package com.example.mymovies.data.model.topRatedMovies

data class TopRatedMoviesResponse(
    val page: Int,
    val results: List<TopRatedMoviesResult>,
    val total_pages: Int,
    val total_results: Int
)