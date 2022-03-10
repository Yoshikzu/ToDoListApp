package br.com.kotlin.todolist.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import br.com.kotlin.todolist.repository.TaskRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.*

class MainViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    val _taskList: LiveData<List<Task>> =
        taskRepository.tasks
    val taskList: LiveData<List<Task>>
        get() = _taskList

    fun save(newTask: Task) {
        viewModelScope.launch {
            taskRepository.save(newTask)
        }
    }
    data class PasswordDto(
        val id: Long,
        val password: String,
        val hash: String
    )
}