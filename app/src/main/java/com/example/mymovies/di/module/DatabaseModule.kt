package com.example.mymovies.di.module

import android.app.Application
import androidx.room.Room
import com.example.mymovies.data.db.MovieDatabase
import com.example.mymovies.utils.Constants.DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Volatile
    private var INSTANCE: MovieDatabase? = null

    @Singleton
    @Provides
    fun provideDatabase(app: Application): MovieDatabase {
        val temInstance = INSTANCE
        if (temInstance != null) {
            return temInstance
        }

        synchronized(this) {
            val instance =
                Room.databaseBuilder(app.applicationContext, MovieDatabase::class.java, DATABASE)
                    .build()
            INSTANCE = instance
            return instance
        }
    }
}