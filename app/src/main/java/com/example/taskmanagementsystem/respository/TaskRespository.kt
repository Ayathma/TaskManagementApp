package com.example.taskmanagementsystem.respository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskmanagementsystem.dao.TaskDao
import com.example.taskmanagementsystem.models.Task
import com.example.taskmanagementsystem.utils.Resource
import com.example.taskmanagementsystem.utils.Resource.*
import com.example.taskmanagementsystem.models.TaskDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import perfetto.protos.StatusResult

class TaskRepository(application: Application) {

    private val taskDao: TaskDao = TaskDatabase.getInstance(application).taskDao


    fun getTaskList() = flow {
        emit(Loading())
        try {
            val result = taskDao.getTaskList()
            emit(Success(result))
        } catch (e: Exception) {
            emit(Error(e.message.toString()))
        }

    }
    fun getTaskListAsc() = flow {
        emit(Loading())
        try {
            val result = taskDao.getTaskListAsc()
            emit(Success(result))
        } catch (e: Exception) {
            emit(Error(e.message.toString()))
        }

    }


    fun insertTask(task: Task) = MutableLiveData<Resource<Long>>().apply {
        postValue(Resource.Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.insertTask(task)
                postValue(Resource.Success(result))
            }
        } catch (e: Exception) {
            postValue(Error(e.message.toString()))
        }
    }
    fun deleteTask(taskId: String) = MutableLiveData<Resource<Int>>().apply {
        postValue(Resource.Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.deleteTask(taskId)
                postValue(Resource.Success(result))
            }
        } catch (e: Exception) {
            postValue(Error(e.message.toString()))
        }
    }

    fun updateTask(task: Task) = MutableLiveData<Resource<Int>>().apply {
        postValue(Resource.Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.updateTask(task)
                postValue(Resource.Success(result))
            }
        } catch (e: Exception) {
            postValue(Error(e.message.toString()))
        }
    }
    fun updateTaskParticularField(taskId: String, title: String, description: String) = MutableLiveData<Resource<Int>>().apply {
        postValue(Resource.Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.updateTaskParticularField(taskId, title, description)
                postValue(Resource.Success(result))
            }
        } catch (e: Exception) {
            postValue(Error(e.message.toString()))
        }
    }

}