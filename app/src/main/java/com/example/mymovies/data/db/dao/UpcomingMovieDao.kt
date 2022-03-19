package com.example.mymovies.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResult

@Dao
interface UpcomingMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUpcomingMoviesToDb(movies: List<UpcomingMoviesResult>)

    @Query("SELECT * FROM popular_movies_table")
    suspend fun getUpcomingMoviesFromDb(): List<UpcomingMoviesResult>

}