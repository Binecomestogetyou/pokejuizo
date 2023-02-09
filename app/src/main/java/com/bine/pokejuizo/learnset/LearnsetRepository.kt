package com.bine.pokejuizo.learnset

import androidx.annotation.WorkerThread

class LearnsetRepository(private val learnsetDAO: LearnsetDAO) {

    val allLearnsets = learnsetDAO.getAllLearnsets()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createLearnset(learnset: Learnset){
        learnsetDAO.addLearnset(learnset)
    }
}