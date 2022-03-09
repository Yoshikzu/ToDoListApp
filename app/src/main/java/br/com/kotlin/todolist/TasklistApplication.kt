package br.com.kotlin.todolist

import android.app.Application
import br.com.kotlin.todolist.data.TaskRoomDatabase

class TaskListApplication : Application(){
    val database: TaskRoomDatabase by lazy { TaskRoomDatabase.getDatabase(this) }
}