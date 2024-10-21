package com.example.myapplication.features.feature_task.domain.use_case

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.myapplication.features.feature_task.data.repository.TaskRepositoryImpl
import com.example.myapplication.features.feature_task.domain.ports.TaskOutput
import kotlinx.coroutines.launch

class GetAllTaskUseCase {

    val taskList = mutableStateOf<List<TaskOutput>>(emptyList())
    private val taskRepository = TaskRepositoryImpl()

//    init {
//        getAllTodo()
//    }

    suspend fun getAllTodo() {
        taskList.value = taskRepository.getAllTasks().reversed()
    }
}