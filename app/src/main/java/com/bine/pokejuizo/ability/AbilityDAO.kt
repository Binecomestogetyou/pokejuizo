package com.bine.pokejuizo.ability

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AbilityDAO {

    @Insert
    suspend fun addAbility(ability: Ability)

    @Query("SELECT * FROM abilities")
    fun getAllAbilities() : Flow<List<Ability>>

    @Update
    fun update(ability: Ability)

    @Delete
    fun delete(ability: Ability)

    @Query("DELETE FROM abilities")
    suspend fun deleteAll() : Int
}