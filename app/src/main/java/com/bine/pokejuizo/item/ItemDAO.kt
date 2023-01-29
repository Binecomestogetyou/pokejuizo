package com.bine.pokejuizo.item

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDAO {

    @Insert
    suspend fun addItem(item : Item)

    @Query("SELECT * FROM items")
    fun getAllItems() : Flow<List<Item>>

    @Update
    fun update(item : Item)

    @Delete
    fun delete(item : Item)

    @Query("DELETE FROM items")
    suspend fun deleteAll() : Int
}