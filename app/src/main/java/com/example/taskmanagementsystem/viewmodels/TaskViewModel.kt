package com.example.taskmanagementsystem.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskmanagementsystem.models.Task
import com.example.taskmanagementsystem.respository.TaskRepository
import com.example.taskmanagementsystem.utils.Resource

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskRepository = TaskRepository(application)


    fun viewTaskList() = taskRepository.getTaskList()
    fun viewTaskListAsc() = taskRepository.getTaskListAsc()
    fun insertTask(task: Task): MutableLiveData<Resource<Long>> {
        return taskRepository.insertTask(task)
    }

    fun deleteTask(taskId: String): MutableLiveData<Resource<Int>> {
        return taskRepository.deleteTask(taskId)
    }
    fun updateTask(task: Task): MutableLiveData<Resource<Int>> {
        return taskRepository.updateTask(task)
    }
    fun updateTaskParticularField(taskId: String, title: String, description: String): MutableLiveData<Resource<Int>> {
        return taskRepository.updateTaskParticularField(taskId, title, description)
    }

}