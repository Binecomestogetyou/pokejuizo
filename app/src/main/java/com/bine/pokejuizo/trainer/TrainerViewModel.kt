package com.bine.pokejuizo.trainer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TrainerViewModel(private val traRepository: TrainerRepository) : ViewModel(){

    val allTrainers = traRepository.allTrainers.asLiveData()

    fun insert(trainer : Trainer) = viewModelScope.launch { traRepository.createTrainer(trainer) }

    fun idIsVacant(id : String) : Boolean {

        if( (allTrainers.value == null) or (allTrainers.value!!.isEmpty())) return true
        else {
            for(t in allTrainers.value!!) if(t.id == id) return false

            return true
        }
    }
}

class TrainerViewModelFactory(private val repository: TrainerRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrainerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TrainerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}