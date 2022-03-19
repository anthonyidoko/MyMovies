package com.example.mymovies.data.model.upComingMovies

data class UpcomingMoviesResponse(
    val dates: UpcomingMoviesDates,
    val page: Int,
    val results: List<UpcomingMoviesResult>,
    val total_pages: Int,
    val total_results: Int
)