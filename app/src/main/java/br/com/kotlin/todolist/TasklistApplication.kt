package br.com.kotlin.todolist

import android.app.Application
import androidx.room.Room

open class TaskListApplication : Application(){
    val database: RoomTaskDataSource by lazy { RoomTaskDataSource.getDatabase(this) }

    companion object {
        var database: AppDataBase? = null
    }


    override fun onCreate() {
        super.onCreate()
        //Room
        database = Room.databaseBuilder(this, AppDataBase::class.java, "my-db").allowMainThreadQueries().build()

        //Stetho
        val initializerBuilder = Stetho.newInitializerBuilder(this)
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        val initializer = initializerBuilder.build()
        Stetho.initialize(initializer)
    }
}