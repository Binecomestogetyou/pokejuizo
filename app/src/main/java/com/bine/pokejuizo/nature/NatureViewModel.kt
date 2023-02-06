package com.bine.pokejuizo.nature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NatureViewModel(private val natureRepository: NatureRepository) : ViewModel(){

    val allNatures = natureRepository.allNatures.asLiveData()

    fun insert(nature: Nature) = viewModelScope.launch { natureRepository.createNature(nature) }
}

class NatureViewModelFactory(private val repository: NatureRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NatureViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NatureViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}