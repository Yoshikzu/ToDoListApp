package br.com.kotlin.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.kotlin.todolist.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val tasks = MutableLiveData<List<Task>>()

    fun getTasks(){
        coroutineScope.launch {
            val tasksList = RoomTaskDataSource(getApplication()).getAll()
            tasks.postValue(tasksList)
        }
    }

    fun check(task: Task){
        coroutineScope.launch {
            val room = RoomTaskDataSource(getApplication())
            val newNote = room.get(task.id)
//            newNote!!.checked = !newNote.checked
            room.add(newNote)
            getTasks()
        }
    }
}