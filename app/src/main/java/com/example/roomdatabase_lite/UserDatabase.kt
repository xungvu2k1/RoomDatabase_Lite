package com.example.roomdatabase_lite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao
    companion object {
        private var instance : UserDatabase? = null
        fun getInstance(context: Context): UserDatabase{
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "userdb"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
                return instance!!
            }
        }
    }