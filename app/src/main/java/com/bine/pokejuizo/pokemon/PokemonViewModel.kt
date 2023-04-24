package com.bine.pokejuizo.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PokemonViewModel(private val pokeRepository: PokemonRepository) : ViewModel(){

    val allPokemon = pokeRepository.allPokemon.asLiveData()

    fun insert(pokemon: Pokemon) = viewModelScope.launch { pokeRepository.createPokemon(pokemon) }
}

class PokemonViewModelFactory(private val repository: PokemonRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PokemonViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}