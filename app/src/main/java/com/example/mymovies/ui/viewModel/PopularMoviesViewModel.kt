package com.example.mymovies.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repository.repositoryInterface.PopularMoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject
@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val popularMoviesRepo: PopularMoviesRepo
): ViewModel() {

    fun getPopularMovies(token: String){
        viewModelScope.launch (Dispatchers.IO){
            try {
                val response = popularMoviesRepo.fetchPopularMovies(token)
                if (response.isSuccessful){
                    Log.d("ZOE", "PopularMovies: ${response.body()?.results}")
                }else{
                    Log.d("ZOE", "PopularMovies Error: ${response.code()}")
                }
            }catch (e: Exception){
                if (e is IOException){
                    //TODO: toast no internet message
                }else{
                    //TODO: catch other errors
                }
                e.printStackTrace()
            }
        }
    }
}