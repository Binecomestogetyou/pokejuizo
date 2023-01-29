package com.bine.pokejuizo.ability

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AbilityViewModel(private val abiRepository: AbilityRepository) : ViewModel(){

    val allAbilities = abiRepository.allAbilities.asLiveData()

    fun insert(ability: Ability) = viewModelScope.launch { abiRepository.createAbility(ability) }
}

class AbilityViewModelFactory(private val repository: AbilityRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AbilityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AbilityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}