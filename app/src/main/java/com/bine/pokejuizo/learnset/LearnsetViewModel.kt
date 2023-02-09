package com.bine.pokejuizo.learnset

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LearnsetViewModel(private val learnsetRepository: LearnsetRepository) : ViewModel(){

    val allLearnsets = learnsetRepository.allLearnsets.asLiveData()

    fun insert(learnset: Learnset) = viewModelScope.launch { learnsetRepository.createLearnset(learnset) }
}

class LearnsetViewModelFactory(private val repository: LearnsetRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearnsetViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LearnsetViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}