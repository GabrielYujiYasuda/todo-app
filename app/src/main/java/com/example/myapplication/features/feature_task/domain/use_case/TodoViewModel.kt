package com.example.myapplication.features.feature_task.domain.use_case

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.features.feature_task.data.repository.TaskRepositoryImpl
import com.example.myapplication.features.feature_task.domain.ports.AddTaskInput
import com.example.myapplication.features.feature_task.domain.ports.TaskOutput
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {

    // Use LiveData and data has got to be used both in Composable and Activities
//    private val _taskList = MutableLiveData<List<TaskOutput>>()
//    val taskList: LiveData<List<TaskOutput>> get() = _taskList

    val taskList = mutableStateOf<List<TaskOutput>>(emptyList())
    private val taskRepository = TaskRepositoryImpl()

    init {
        getAllTodo()
    }

    private fun getAllTodo() {
        viewModelScope.launch {
            taskList.value = taskRepository.getAllTasks().reversed()
        }
    }

    fun addTask(inputText: String) {
        viewModelScope.launch {
            val newTask = AddTaskInput(inputText, Date.from(Instant.now()))
            taskRepository.addTask(newTask)
            getAllTodo()
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            taskRepository.deleteTaskById(id)
            getAllTodo()
        }
    }
}
