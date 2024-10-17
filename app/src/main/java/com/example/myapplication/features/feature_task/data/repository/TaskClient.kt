package com.example.myapplication.features.feature_task.data.repository

import com.example.myapplication.features.feature_task.domain.ports.AddTaskInput
import com.example.myapplication.features.feature_task.domain.ports.TaskOutput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TaskClient {

    @GET("task")
    suspend fun getAllTasks(): List<TaskOutput>

    @POST("task")
    suspend fun addTask(@Body task: AddTaskInput): Response<Void>

    @DELETE("task/{id}")
    suspend fun deleteTaskById(@Path("id") id: Int): Response<Void>

//    @GET("/{id}")
//    suspend fun getTaskById(@Path("id") id: Int): Response<TodoResponse>

//    @PUT("/{id}")
//    suspend fun updateTaskByiD(@Path("id") id: Int): Response<TodoResponse>
}