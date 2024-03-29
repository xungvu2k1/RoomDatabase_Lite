package com.example.roomdatabase_lite.song

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase_lite.UserEntity

@Dao
interface SongDao {

    @Query("SELECT * FROM songs")
    fun getAllSongs(): List<Song>?

    @Insert
    fun insertSong(song: Song)
}