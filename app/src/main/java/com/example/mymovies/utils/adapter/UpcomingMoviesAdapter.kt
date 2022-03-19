package com.example.mymovies.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.R
import com.example.mymovies.data.model.upComingMovies.UpcomingMoviesResult

class UpcomingMoviesAdapter: RecyclerView.Adapter<UpcomingMoviesAdapter.UpcomingMoviesViewHolder>() {

    private lateinit var clickListener: SetOnItemClickListener
    private val differCallBack = object: DiffUtil.ItemCallback<UpcomingMoviesResult>(){
        override fun areItemsTheSame(
            oldItem: UpcomingMoviesResult,
            newItem: UpcomingMoviesResult
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UpcomingMoviesResult,
            newItem: UpcomingMoviesResult
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    inner class UpcomingMoviesViewHolder(view: View, listener: SetOnItemClickListener): RecyclerView.ViewHolder(view){

        init {
            itemView.setOnClickListener {
                listener.onItemClick(differ.currentList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_movies_item, parent,false)
        return UpcomingMoviesViewHolder(view,clickListener)
    }

    override fun onBindViewHolder(holder: UpcomingMoviesViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.apply {

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    interface SetOnItemClickListener{
        fun onItemClick(item: UpcomingMoviesResult)
    }

    fun setOnItemClick(listener: SetOnItemClickListener){
        clickListener = listener
    }


}