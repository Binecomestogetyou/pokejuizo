package com.bine.pokejuizo.pokemon

import androidx.annotation.WorkerThread


class PokemonRepository(private val pokemonDAO: PokemonDAO) {

    val allPokemon = pokemonDAO.getAllAbilities()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createPokemon(pokemon: Pokemon){
        pokemonDAO.addPokemon(pokemon)
    }
}