package com.example.roomdatabase_lite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(

    val firstName: String,
    val lastName : String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
