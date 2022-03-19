package com.example.mymovies.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mymovies.R
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResult
import com.example.mymovies.ui.viewModel.UpcomingMoviesViewModel
import com.example.mymovies.utils.adapter.UpcomingMoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpcomingMoviesFragment : Fragment() {

    private val viewModel: UpcomingMoviesViewModel by viewModels()
    private val adapter by lazy { UpcomingMoviesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming_movies, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val token = getString(R.string.token)

        viewModel.getUpcomingMovies(token)

        setUpAdapter()
    }

    private fun setUpAdapter() {
        viewModel.upcomingMovies.observe(viewLifecycleOwner, Observer {
            adapter.differ.submitList(it)
        })

        adapter.setOnItemClick(object : UpcomingMoviesAdapter.SetOnItemClickListener{
            override fun onItemClick(item: UpcomingMoviesResult) {
                //TODO: NAVIGATE HERE
            }

        })
    }


}