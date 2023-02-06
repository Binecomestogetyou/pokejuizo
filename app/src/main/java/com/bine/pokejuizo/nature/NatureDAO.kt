package com.bine.pokejuizo.nature

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NatureDAO {

    @Insert
    suspend fun addNature(nature: Nature)

    @Query("SELECT * FROM natures")
    fun getAllNatures() : Flow<List<Nature>>

    @Update
    fun update(nature: Nature)

    @Delete
    fun delete(nature: Nature)

    @Query("DELETE FROM natures")
    suspend fun deleteAll() : Int
}