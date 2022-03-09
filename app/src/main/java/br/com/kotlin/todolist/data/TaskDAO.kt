package br.com.kotlin.todolist.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {

    @Insert
    suspend fun insert(task: Task)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task:Task)

    @Query("SELECT * from task WHERE id = :id")
    fun getTask(id: Int): Flow<Task>

    @Query("SELECT * from task ORDER BY date, hour ASC")
    fun getTasks(): Flow<List<Task>>

}