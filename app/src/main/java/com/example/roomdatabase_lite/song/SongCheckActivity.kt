package com.example.roomdatabase_lite.song

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase_lite.R
import com.example.roomdatabase_lite.UserDatabase
import com.example.roomdatabase_lite.UserEntity
import com.example.roomdatabase_lite.databinding.ActivityMainBinding
import com.example.roomdatabase_lite.databinding.ActivitySongCheckBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SongCheckActivity : AppCompatActivity() {
    private lateinit var floatingAddSong : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mActivitySongCheckBinding = ActivitySongCheckBinding.inflate(layoutInflater)
        setContentView(mActivitySongCheckBinding.root)

        floatingAddSong = mActivitySongCheckBinding.floatingAddSong
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