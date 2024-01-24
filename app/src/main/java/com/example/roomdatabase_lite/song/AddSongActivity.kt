package com.example.roomdatabase_lite.song

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabase_lite.R
import com.example.roomdatabase_lite.databinding.ActivityAddSongBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddSongActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddSongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddSongAdd.setOnClickListener{
            val title = binding.edTitleAdd.text.toString()
            val artist = binding.edArtistAdd.text.toString()
            val album = binding.edAlbumAdd.text.toString()
            val filePath = binding.edFilePathAdd.text.toString()

            val song = Song(0, title, artist, album, filePath)
            MainScope().launch {
                withContext(Dispatchers.IO) {
                    // Retrieve songs on a background thread
                    SongDatabase.getInstance(applicationContext).songDao().insertSong(song)
                }
            }
            val intent = Intent(this, SongCheckActivity::class.java)
            startActivity(intent)

        }
    }
}