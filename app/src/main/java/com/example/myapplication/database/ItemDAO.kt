package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TopicDAO {
    @Insert
    fun insertData(topic: Topic)

    @Delete
    fun deleteData(topic: Topic)

    @Update
    fun updateData(topic: Topic)

    @Query("SELECT * FROM Topics")
    fun getAllData(): MutableList<Topic>

    @Query("SELECT * FROM Topics WHERE id = :id")
    fun getData(id: Int): Topic

    @Query("SELECT * FROM Topics WHERE liked = 1")
    fun getLikedData(): MutableList<Topic>
}