package com.bine.pokejuizo.nature

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NatureRepository(private val natureDAO: NatureDAO) {

    val allNatures = natureDAO.getAllNatures()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllNames() : List<String> { return natureDAO.getAllNames() }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getConfidence(name : String) : Int { return natureDAO.getConfidence(name) }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createNature(nature: Nature){
        natureDAO.addNature(nature)
    }
}