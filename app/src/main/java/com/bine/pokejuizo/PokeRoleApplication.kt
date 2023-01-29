package com.bine.pokejuizo

import android.app.Application
import com.bine.pokejuizo.ability.AbilityRepository
import com.bine.pokejuizo.trainer.TrainerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PokeRoleApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val dataBase by lazy { DataBase.getDataBase(this, applicationScope) }
    val trainerRepository by lazy { TrainerRepository(dataBase.trainerDAO()) }
    val abilityRepository by lazy { AbilityRepository(dataBase.abilityDAO()) }
}