package br.com.kotlin.todolist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.kotlin.todolist.model.Task

@Entity(tableName = "task")
data class Task(
    @ColumnInfo(name="id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "hour")
    val hour: String,
    @ColumnInfo(name = "date")
    val date: String
){
    companion object {
        fun fromTask(task: Task) =
            br.com.kotlin.todolist.data.Task(task.id,task.title,task.hour,task.date)
    }

    fun toTask() = Task(id,title,hour,date)
}