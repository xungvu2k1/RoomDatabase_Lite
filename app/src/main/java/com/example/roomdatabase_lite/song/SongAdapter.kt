package com.example.roomdatabase_lite.song

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase_lite.R

class SongAdapter(val context: Context) : RecyclerView.Adapter<SongAdapter.SongViewHolder>(){
    private lateinit var mSongList: List<Song>

    fun setData(list: List<Song>) {
        this.mSongList = list
        // cực kì quan trọng để thông báo về sự thay đổi của dữ liệu
        notifyDataSetChanged()
    }

    class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
        val artist: TextView = view.findViewById(R.id.tv_artist)
        val album: TextView = view.findViewById(R.id.tv_album)
        val filePath: TextView = view.findViewById(R.id.tv_filePath)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mSongList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.title.text = mSongList[position].title
        holder.artist.text = mSongList[position].artistName
        holder.album.text = mSongList[position].album
        holder.filePath.text = mSongList[position].filePath

    }
}