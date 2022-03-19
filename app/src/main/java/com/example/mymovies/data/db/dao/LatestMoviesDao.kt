package com.example.mymovies.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymovies.data.model.latestMovies.LatestMovieResponse

@Dao
interface LatestMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLatestMovieToDb(latestMovieResponse: LatestMovieResponse)

    @Query("SELECT * FROM latest_movie_table")
    suspend fun fetchLatestMovieFromDb(): LatestMovieResponse
}