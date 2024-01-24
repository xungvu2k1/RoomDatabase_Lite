package com.example.roomdatabase_lite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll() : List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(users: UserEntity)

    @Delete
    fun delete(user: UserEntity)


}