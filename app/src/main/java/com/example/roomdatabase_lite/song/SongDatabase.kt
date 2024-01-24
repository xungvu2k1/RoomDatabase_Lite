package com.example.roomdatabase_lite.song

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase_lite.UserDatabase

@Database(entities = [Song::class], version = 1)
abstract class SongDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao

    companion object {
        private var instance : SongDatabase? = null
        fun getInstance(context: Context): SongDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    SongDatabase::class.java,
                    "song.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}