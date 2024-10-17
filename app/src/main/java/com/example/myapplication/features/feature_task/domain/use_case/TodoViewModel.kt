package com.example.myapplication.features.feature_task.domain.use_case

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.features.feature_task.data.repository.TaskRepositoryImpl
import com.example.myapplication.features.feature_task.domain.ports.AddTaskInput
import com.example.myapplication.features.feature_task.domain.ports.TaskOutput
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {

    private var _taskList = MutableLiveData<List<TaskOutput>>()
    val taskList: LiveData<List<TaskOutput>> get() = _taskList

    val taskRepository = TaskRepositoryImpl()
    init {
        getAllTodo()
    }

    private fun getAllTodo() {
        viewModelScope.launch {
            _taskList.value = taskRepository.getAllTasks().reversed()
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
