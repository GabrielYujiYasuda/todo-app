package com.example.myapplication.features.feature_task.data.repository

import com.example.myapplication.features.feature_task.data.data_source.client.RetrofitInstance
import com.example.myapplication.features.feature_task.domain.ports.AddTaskInput
import com.example.myapplication.features.feature_task.domain.ports.TaskOutput

class TaskRepositoryImpl {
    private val todoList = mutableListOf<TaskOutput>()
    private val taskService = RetrofitInstance.api

    suspend fun getAllTasks(): List<TaskOutput> {
        return try {
            val response = taskService.getAllTasks()

            todoList.clear()
            response?.let { todoList.addAll(it) }

            todoList
        } catch (e: Exception) {
            println("Manager error: getAllTasks => " + e.message)
            emptyList()
        }
    }

    suspend fun addTask(newTask: AddTaskInput) {

        try {
            taskService.addTask(newTask)
        } catch (e: Exception){
            println("Manager error: addTask => " + e.message)
        }
    }

    suspend fun deleteTaskById(id: Int) {
        try {
            taskService.deleteTaskById(id)
            todoList.removeIf { it.id == id }
        } catch (e: Exception) {
            println("Manager error: deleteTask => " + e.message)
        }
    }
}