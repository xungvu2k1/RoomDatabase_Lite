package com.example.roomdatabase_lite.song

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase_lite.databinding.ActivitySongCheckBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SongCheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mActivitySongCheckBinding = ActivitySongCheckBinding.inflate(layoutInflater)
        setContentView(mActivitySongCheckBinding.root)

        val recyclerView = mActivitySongCheckBinding.rcvSong

        recyclerView.layoutManager = LinearLayoutManager(this)

        val btnAdd = mActivitySongCheckBinding.btnAdd
        btnAdd.setOnClickListener{
            val intent = Intent(this,AddSongActivity::class.java)
            startActivity(intent)
        }

        MainScope().launch {
            val songList = withContext(Dispatchers.IO) {
                // Retrieve songs on a background thread
                SongDatabase.getInstance(applicationContext).songDao().getAllSongs()
            }

            val songAdapter = SongAdapter(this@SongCheckActivity)
            songAdapter.setData(getSongList())
            if (songList != null){
                songAdapter.setData(songList)
            }


            // Make sure the adapter is created and set on the main thread
            withContext(Dispatchers.Main) {
                recyclerView.adapter = songAdapter
            }
        }
    }

    private fun getSongList() : List<Song>{
        val songList : MutableList<Song> = ArrayList()
        songList.add(Song(0, "Con mua ngang qua", "Son tung mtp", "Sky", "source//sontung//sky"))
        songList.add(Song(1, "Con mua ngang qua", "Son tung mtp", "Sky", "source//sontung//sky"))
        songList.add(Song(2, "Con mua ngang qua", "Son tung mtp", "Sky", "source//sontung//sky"))
        songList.add(Song(3, "Con mua ngang qua", "Son tung mtp", "Sky", "source//sontung//sky"))
        return songList
    }
}