package com.bine.pokejuizo.nature

import androidx.lifecycle.LiveData
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

    @Query("SELECT confidence FROM natures WHERE name = :name")
    suspend fun getConfidence(name : String) : Int

    @Query("SELECT name FROM natures")
    suspend fun getAllNames() : List<String>
}