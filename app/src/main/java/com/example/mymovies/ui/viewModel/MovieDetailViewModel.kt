package com.example.mymovies.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.mymovies.data.repository.repositoryInterface.MovieDetailRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailRepo: MovieDetailRepo
    ):ViewModel() {
}