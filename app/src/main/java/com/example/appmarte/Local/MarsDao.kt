package com.example.appmarte.Local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appmarte.Model.Remote.MarsRealState

@Dao
interface MarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask( task: MarsRealState)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTask( task: List<MarsRealState>)

    @Update
    suspend fun updateTask(task: MarsRealState)

    @Delete
    suspend fun deleteTask(task: MarsRealState)

    @Query("DELETE FROM mars_table")
    suspend fun deleteAll()

    // TRAE TODAS LAS TAREAS
    @Query("SELECT * FROM mars_table order by localid ")
    fun getAllTask():LiveData<List<MarsRealState>>

}