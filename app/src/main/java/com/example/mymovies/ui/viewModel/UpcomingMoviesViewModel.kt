package com.example.mymovies.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResult
import com.example.mymovies.data.repository.repositoryInterface.UpcomingMoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject
@HiltViewModel
class UpcomingMoviesViewModel @Inject constructor(
    private val upcomingMoviesRepo: UpcomingMoviesRepo
): ViewModel() {


    private val _upcomingMovies = MutableLiveData<List<UpcomingMoviesResult>>()
    val upcomingMovies: LiveData<List<UpcomingMoviesResult>> = _upcomingMovies

    fun getUpcomingMovies(token: String){
        Log.d("ZOE", "getUpcomingMovies: ")
        viewModelScope.launch (Dispatchers.IO){
            try {
                val response = upcomingMoviesRepo.getUpcomingMovie(token)
                if (response.isSuccessful){
                    _upcomingMovies.postValue(response.body()?.results)
                    Log.d("ZOE", "getUpcomingMovies: ${response.body()?.results}")
                }else{
                    Log.d("ZOE", "UpcomingMovies code: ${response.code()}")
                }
            }catch (e: Exception){
                if (e is IOException){
                    //TODO: TOAST NETWORK ERROR MESSAGE
                    Log.d("ZOE", "getUpcomingMovies:NO INTERNET ")
                }else{

                    //TODO: CATCH OTHER ERRORS
                    Log.d("ZOE", "getUpcomingMovies:${e.message} ")


                }
            }
        }
    }
}