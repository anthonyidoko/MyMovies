package com.example.mymovies.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repository.repositoryInterface.LatestMovieRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject
@HiltViewModel
class LatestMoviesViewModel @Inject constructor(
    private val latestMovieRepo: LatestMovieRepo
): ViewModel() {

    fun getLatestMovies(token: String){
        viewModelScope.launch (Dispatchers.IO){
            try {
                val response = latestMovieRepo.getLatestMovie(token)
                if (response.isSuccessful){
                    Log.d("ZOE", "LatestMovies: ${response.body()}")
                }else{
                    Log.d("ZOE", "LatestMovies Error: ${response.code()}")
                }
            }catch (e: Exception){
                if (e is IOException){
                    //TODO: toast no network text
                    Log.d("ZOE", "LatestMovies Error: ${e.message}")
                }else{
                    //TODO: catch other errors
                    Log.d("ZOE", "LatestMovies Error: ${e.message}")
                }
            }
        }
    }
}