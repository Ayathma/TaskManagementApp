package com.example.taskmanagementsystem.dao

import androidx.room.*
import com.example.taskmanagementsystem.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task ORDER BY date DESC")
    fun taskList(): Flow<List<Task>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task:Task): Long
}