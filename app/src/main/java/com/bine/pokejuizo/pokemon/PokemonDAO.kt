package com.bine.pokejuizo.pokemon

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDAO {
    
    @Insert
    suspend fun addPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM Pokedex")
    fun getAllAbilities() : Flow<List<Pokemon>>

    @Update
    fun update(pokemon: Pokemon)

    @Delete
    fun delete(pokemon: Pokemon)

    @Query("DELETE FROM Pokedex")
    suspend fun deleteAll() : Int
}