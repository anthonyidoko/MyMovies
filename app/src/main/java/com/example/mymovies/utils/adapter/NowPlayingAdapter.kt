package com.example.mymovies.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.R
import com.example.mymovies.data.model.nowPlayingMovies.NowPlayingResult

class NowPlayingAdapter: RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder>() {

    private lateinit var clickListener: SetItemClickListener

    private val differCallBack = object: DiffUtil.ItemCallback<NowPlayingResult>(){
        override fun areItemsTheSame(
            oldItem: NowPlayingResult,
            newItem: NowPlayingResult
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NowPlayingResult,
            newItem: NowPlayingResult
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    inner class NowPlayingViewHolder(view: View, listener: SetItemClickListener): RecyclerView.ViewHolder(view){

        init {
            itemView.setOnClickListener {
                listener.onItemClick(differ.currentList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.now_playing_item, parent, false)
        return NowPlayingViewHolder(view,clickListener)
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        val currentMovie = differ.currentList[position]
        holder.apply {

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    interface SetItemClickListener{
        fun onItemClick(item: NowPlayingResult)
    }

    fun setItemClickListener(listener: SetItemClickListener){
        clickListener = listener
    }



}