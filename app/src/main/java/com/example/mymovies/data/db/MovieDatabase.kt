package com.example.mymovies.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mymovies.data.db.dao.*
import com.example.mymovies.data.model.latestMovies.LatestMovieResponse
import com.example.mymovies.data.model.nowPlayingMovies.NowPlayingResult
import com.example.mymovies.data.model.popularMovies.PopularMoviesResult
import com.example.mymovies.data.model.topRatedMovies.TopRatedMoviesResult
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResult
import com.example.mymovies.data.repository.repositoryInterface.UpcomingMoviesRepo
import com.example.mymovies.utils.MoviesTypeConverter

@Database(
    entities = [NowPlayingResult::class, PopularMoviesResult::class, TopRatedMoviesResult::class, LatestMovieResponse::class, UpcomingMoviesResult::class],
    version = 1
)
@TypeConverters(MoviesTypeConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun latestMoviesDao(): LatestMoviesDao
    abstract fun popularMoviesDao(): PopularMoviesDao
    abstract fun upcomingMoviesDao(): UpcomingMovieDao

}