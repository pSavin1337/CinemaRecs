package com.nc.cinemarecs.presentation.recommendations

import android.net.Uri
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nc.cinemarecs.databinding.RecommendationsItemBinding
import com.nc.cinemarecs.domain.entities.CinemaEntity


class RecommendationsAdapter :
    RecyclerView.Adapter<RecommendationsAdapter.RecommendationsViewHolder>() {

    var recommendationsList = listOf<CinemaEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationsViewHolder {
        val binding = RecommendationsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecommendationsViewHolder(binding)
    }

    override fun getItemCount(): Int = recommendationsList.size

    override fun onBindViewHolder(holder: RecommendationsViewHolder, position: Int) {
        with(holder.binding) {
            Glide.with(recommendationItemPoster)
                .load(recommendationsList[position].poster)
                .into(recommendationItemPoster)
            detailsName.text = recommendationsList[position].name
            playVideo(recommendationsList[position].trailer!!, detailsTrailer)
            detailsDescription.text = recommendationsList[position].description
            recommendationItemPoster.setOnClickListener {
                recommendationItemPoster.visibility = GONE
                detailsDescription.visibility = VISIBLE
                detailsName.visibility = VISIBLE
                detailsTrailer.visibility = VISIBLE
            }
            recItem.setOnClickListener {
                recommendationItemPoster.visibility = VISIBLE
                detailsDescription.visibility = GONE
                detailsName.visibility = GONE
                detailsTrailer.visibility = GONE
            }
        }
    }

    private fun playVideo(path: String, videoView: VideoView) {
        try {
            val mediaController = MediaController(videoView.context)
            val video: Uri = Uri.parse(path)
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(video)
            videoView.setOnPreparedListener {
                videoView.start()
            }
        } catch (e: Exception) {
            Toast.makeText(videoView.context, "Not working", Toast.LENGTH_SHORT).show()
        }
    }

    class RecommendationsViewHolder(val binding: RecommendationsItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
