package br.com.kotlin.todolist.di

import br.com.kotlin.todolist.database.TaskDatabase
import br.com.kotlin.todolist.repository.TaskRepository
import br.com.kotlin.todolist.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module{
    single { TaskRepository(get()) }
}

val daoModule = module{
    single{TaskDatabase.getInstance(androidContext()).taskDao }
}