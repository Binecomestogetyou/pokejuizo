package com.bine.pokejuizo.trainer

import androidx.annotation.WorkerThread


class TrainerRepository(private val trainerDAO: TrainerDAO) {

     val allTrainers = trainerDAO.getAllTrainers()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createTrainer(trainer: Trainer){
        trainerDAO.addTrainer(trainer)
    }
}