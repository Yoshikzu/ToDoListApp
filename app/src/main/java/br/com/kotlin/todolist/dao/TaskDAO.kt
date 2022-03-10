package br.com.kotlin.todolist.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import br.com.kotlin.todolist.data.Task
import androidx.room.OnConflictStrategy

@Dao
interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun remove(task: Task)

    @Query("SELECT * FROM task")
    fun getAll(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE id = :id")
    fun get(id: Long): Task?

}