package com.bine.pokejuizo.nature

import androidx.annotation.WorkerThread

class NatureRepository(private val natureDAO: NatureDAO) {

    val allNatures = natureDAO.getAllNatures()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createNature(nature: Nature){
        natureDAO.addNature(nature)
    }
}