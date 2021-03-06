package cs4750final.plannerapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import cs4750final.plannerapp.Task
import java.util.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM task ORDER BY NOT isSolved DESC, date")
    fun getTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE id=(:id)")
    fun getTask(id: UUID): LiveData<Task?>

    @Query("SELECT * FROM task ORDER BY date DESC")
    fun getTasksByDatetime(): LiveData<List<Task>>

    @Update
    fun updateTask(task: Task)

    @Insert
    fun addTask(task: Task)
}