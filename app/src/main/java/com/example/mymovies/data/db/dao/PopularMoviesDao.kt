package com.example.mymovies.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymovies.data.model.popularMovies.PopularMoviesResult

@Dao
interface PopularMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularMoviesToDb(movies: List<PopularMoviesResult>)

    @Query("SELECT * FROM popular_movies_table")
    suspend fun getPopularMoviesFromDb(): List<PopularMoviesResult>

}