package com.example.taskmanagementsystem.models

import android.content.Context
import androidx.room.Database
import androidx.room.*
import com.example.taskmanagementsystem.converters.TypeConverter
import com.example.taskmanagementsystem.dao.TaskDao
import com.example.taskmanagementsystem.models.Task

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDao : TaskDao
    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null
        fun getInstance(context: Context): TaskDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    name = "task_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}