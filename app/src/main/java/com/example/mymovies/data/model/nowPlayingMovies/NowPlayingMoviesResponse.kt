package com.example.mymovies.data.model.nowPlayingMovies

data class NowPlayingMoviesResponse(
    val dates: NowPlayingDates,
    val page: Int,
    val results: List<NowPlayingResult>,
    val total_pages: Int,
    val total_results: Int
)