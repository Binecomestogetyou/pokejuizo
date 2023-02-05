package com.bine.pokejuizo.move

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoveViewModel(private val moveRepository: MoveRepository) : ViewModel(){

    val allMoves = moveRepository.allMoves.asLiveData()

    fun insert(move: Move) = viewModelScope.launch { moveRepository.createMove(move) }
}

class MoveViewModelFactory(private val repository: MoveRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoveViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MoveViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}