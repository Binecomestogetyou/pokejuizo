package com.bine.pokejuizo

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PokeRoleApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val dataBase by lazy { DataBase.getDataBase(this, applicationScope) }
    val repository by lazy { TrainerRepository(dataBase.trainerDAO()) }
}