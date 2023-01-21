package com.bine.pokejuizo

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainerDAO {

    @Insert
    suspend fun addTrainer(trainer : Trainer)

    @Query("SELECT * FROM trainers")
    fun getAllTrainers() : Flow<List<Trainer>>

    @Update
    fun update(trainer : Trainer)

    @Delete
    fun delete(trainer: Trainer)

    @Query("DELETE FROM trainers")
    suspend fun deleteAll() : Int
}