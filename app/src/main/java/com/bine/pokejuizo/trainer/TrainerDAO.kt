package com.bine.pokejuizo.trainer

import androidx.room.*
import com.bine.pokejuizo.Converters
import kotlinx.coroutines.flow.Flow

@Dao
@TypeConverters(Converters::class)
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