package com.gmt.playlistmaker


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


class TrackAdapter(private val tracks: List<Track>): Adapter<TrackViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(tracks[position])
    }

    override fun getItemCount() = tracks.size
}

class TrackViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val ivCover = itemView.findViewById<ImageView>(R.id.ivCover)
    private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    private val tvArtist = itemView.findViewById<TextView>(R.id.tvArtist)
    private val tvTime = itemView.findViewById<TextView>(R.id.tvTime)
    fun bind(track: Track) {
        Glide.with(itemView).load(track.artworkUrl100)
            .centerCrop().placeholder(R.drawable.placeholder)
            .transform(RoundedCorners(2))
            .into(ivCover)

        tvTitle.text = track.trackName
        tvArtist.text = track.artistName
        tvTime.text = track.trackTime
    }

}
