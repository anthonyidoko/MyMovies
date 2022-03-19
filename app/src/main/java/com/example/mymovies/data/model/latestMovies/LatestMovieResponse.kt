package com.example.mymovies.data.model.latestMovies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "latest_movie_table")
data class LatestMovieResponse(
    val adult: Boolean,
    val backdrop_path: Any,
    val belongs_to_collection: Any,
    val budget: Int,
    var genres: List<Genre?>? = null,
    val homepage: String,
    @PrimaryKey
    val id: Int,
    val imdb_id: Any,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: Any,
    val production_companies: List<Any>,
    val production_countries: List<Any>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<Any>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)