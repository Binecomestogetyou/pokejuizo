package com.bine.pokejuizo.move

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MoveDAO {

    @Insert
    suspend fun addMove(move: Move)

    @Query("SELECT * FROM moves")
    fun getAllMoves() : Flow<List<Move>>

    @Update
    fun update(move: Move)

    @Delete
    fun delete(move: Move)

    @Query("DELETE FROM moves")
    suspend fun deleteAll() : Int
}