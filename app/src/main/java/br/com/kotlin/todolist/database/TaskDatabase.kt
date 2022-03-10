package br.com.kotlin.todolist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.kotlin.todolist.dao.TaskDAO
import br.com.kotlin.todolist.data.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {

    abstract val taskDao: TaskDAO

    companion object {

        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase? {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java, "task.db"
                    ).fallbackToDestructiveMigration()
                     .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}