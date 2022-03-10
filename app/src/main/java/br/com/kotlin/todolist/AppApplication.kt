package br.com.kotlin.todolist

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import br.com.kotlin.todolist.di.daoModule
import br.com.kotlin.todolist.di.repositoryModule
import br.com.kotlin.todolist.di.viewModelModule

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(viewModelModule)
            modules(repositoryModule)
            modules(daoModule)
        }
    }
}