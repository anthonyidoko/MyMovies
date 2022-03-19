package com.example.mymovies.utils

import androidx.room.TypeConverter
import com.example.mymovies.data.model.latestMovies.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MoviesTypeConverter {

    @TypeConverter
    fun fromListToString(items: List<Int>): String{
        return Gson().toJson(items)
    }

    @TypeConverter
    fun toListFromString(value: String): List<Int>{
        val result = object : TypeToken<List<Int>>(){}.type
        return Gson().fromJson(value, result)
    }

    @TypeConverter
    fun fromListOfAnyToString(items: List<Any>): String{
        return Gson().toJson(items)
    }

    @TypeConverter
    fun toListOfAnyFromString(value: String): List<Any>{
        val result = object : TypeToken<List<Any>>(){}.type
        return Gson().fromJson(value, result)
    }

    @TypeConverter
    fun fromAnyToString(genre: Any): String{
        return Gson().toJson(genre)
    }

    @TypeConverter
    fun toAnyFromString(value: String): Any{
        val result = object : TypeToken<Any>(){}.type
        return Gson().fromJson(value, result)
    }

    @TypeConverter
    fun toListOfStrings(genres: List<Genre?>?): String?{
        if (genres == null){
            return null
        }
        return Gson().toJson(genres)
    }

    @TypeConverter
    fun toStringFromGenres(value: String): List<Genre>{
        val result = object : TypeToken<List<Genre>>(){}.type
        return Gson().fromJson(value, result)
    }

    //TODO: take a list of genre,
// convert it to a list of strings,
// convert list of string to string

}