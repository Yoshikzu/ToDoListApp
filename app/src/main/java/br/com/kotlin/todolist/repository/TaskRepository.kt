package br.com.kotlin.todolist.repository

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import br.com.kotlin.todolist.dao.TaskDAO
import br.com.kotlin.todolist.data.Task
import br.com.kotlin.todolist.database.TaskDatabase

class TaskRepository(private val taskDao: TaskDAO) {
    val tasks: LiveData<List<Task>>
        get() = taskDao.getAll()

    suspend fun save(newtask: Task){
        taskDao.save(Task(title = newtask.title, hour = newtask.hour, date = newtask.date))
    }

    suspend fun update(task: Task){
        taskDao.update(task)
    }

    suspend fun delete(task: Task){
        taskDao.remove(task)
    }

    fun get(task:Task): Task = taskDao.get(task.id)


}

/*
*    var db: TaskDAO = TaskDatabase.getInstance(context)?.taskDao()!!

    //Fetch All the Tasks
    fun getAllTasks(): List<Task> {
        return db.getAllTask()
    }

    // Insert new task
    fun insertTask(task: Task) {
        insertAsyncTask(db).execute(task)
    }

    // update task
    fun updateTask(task: Task) {
        db.updateTask(task)
    }

    // Delete task
    fun deleteTask(task: Task) {
        db.deleteTask(task)
    }

    private class insertAsyncTask internal constructor(private val taskDao: TaskDAO) :
        AsyncTask<Task, Void, Void>() {

        override fun doInBackground(vararg params: Task): Void? {
            taskDao.insertUser(params[0])
            return null
        }
    }
*
* */