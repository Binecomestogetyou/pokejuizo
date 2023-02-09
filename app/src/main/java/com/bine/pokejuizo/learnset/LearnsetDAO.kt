package com.bine.pokejuizo.learnset

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface LearnsetDAO {
    
    @Insert
    suspend fun addLearnset(learnset: Learnset)

    @Query("SELECT * FROM learnsets")
    fun getAllLearnsets() : Flow<List<Learnset>>

    @Update
    fun update(learnset : Learnset)

    @Delete
    fun delete(learnset : Learnset)

    @Query("DELETE FROM learnsets")
    suspend fun deleteAll() : Int
}