package br.com.kotlin.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.kotlin.todolist.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    var currentTask = MutableLiveData<Task>()

    fun save(task: Task){
        coroutineScope.launch {
            RoomTaskDataSource(getApplication()).add(task)
        }
    }

    fun get(id: Long){
        coroutineScope.launch {
            val task = RoomTaskDataSource(getApplication()).get(id)
            currentTask.postValue(task!!)
        }
    }

    fun delete(task: Task){
        coroutineScope.launch {
            RoomTaskDataSource(getApplication()).remove(task)
        }
    }
}