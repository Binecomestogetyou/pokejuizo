package com.bine.pokejuizo.nature

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NatureViewModel(private val natureRepository: NatureRepository) : ViewModel(){

    val allNatures = natureRepository.allNatures.asLiveData()

    fun insert(nature: Nature) = viewModelScope.launch { natureRepository.createNature(nature) }

    fun getAllNames() : List<String> = runBlocking() {

        natureRepository.getAllNames()
    }

    fun getConfidence(name: String) : Int = runBlocking() {

        natureRepository.getConfidence(name)
    }
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