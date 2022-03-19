package com.example.mymovies.di.module

import com.example.mymovies.data.MovieService
import com.example.mymovies.data.db.MovieDatabase
import com.example.mymovies.data.repository.repositoryImpl.*
import com.example.mymovies.data.repository.repositoryInterface.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun providePopularMovies(
        movieDb: MovieDatabase,
        movieService: MovieService
    ): PopularMoviesRepo{
        return PopularMovieRepoImpl(movieService, movieDb)

    }

    @Provides
    @Singleton
    fun provideUpcomingMovies(
        movieDb: MovieDatabase, movieService: MovieService
    ): UpcomingMoviesRepo{
        return  UpcomingMoviesRepoImpl(movieService, movieDb)
    }

    @Provides
    @Singleton
    fun provideLatestMovies(
        movieDb: MovieDatabase, movieService: MovieService
    ): LatestMovieRepo{
        return LatestMoviesRepoImpl(movieService, movieDb)
    }


    @Provides
    @Singleton
    fun provideMovieDetail(
        movieDb: MovieDatabase, movieService: MovieService
    ):MovieDetailRepo{
        return MovieDetailImpl(movieService)
    }

}