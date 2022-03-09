package br.com.kotlin.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TaskListViewModel(private val taskDao: TaskDao) : ViewModel() {

}

class TaskListViewModelFactory(private val taskDao: TaskDao) : ViewModelProvider.Factory {

}