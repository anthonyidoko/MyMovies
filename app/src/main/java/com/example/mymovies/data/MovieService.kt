package com.example.mymovies.data

import com.example.mymovies.data.model.latestMovies.LatestMovieResponse
import com.example.mymovies.data.model.movieDetail.MovieDetailResponse
import com.example.mymovies.data.model.nowPlayingMovies.NowPlayingMoviesResponse
import com.example.mymovies.data.model.popularMovies.PopularMovies
import com.example.mymovies.data.model.topRatedMovies.TopRatedMoviesResponse
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") accessKey: String
    ): Response<NowPlayingMoviesResponse>


    @GET("popular")
    suspend fun getPopularMovies(
        @Query("api_key") accessKey: String
    ): Response<PopularMovies>

    @GET("top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") accessKey: String
    ): Response<TopRatedMoviesResponse>


    @GET("upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") accessKey: String
    ): Response<UpcomingMoviesResponse>

    @GET("latest")
    suspend fun getLatestMovies(
        @Query("api_key") accessKey: String
    ): Response<LatestMovieResponse>



    @GET("{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") accessKey: String
    ): Response<MovieDetailResponse>
}