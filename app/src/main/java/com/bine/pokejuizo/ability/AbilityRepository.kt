package com.bine.pokejuizo.ability

import androidx.annotation.WorkerThread


class AbilityRepository(private val abilityDAO: AbilityDAO) {

    val allAbilities = abilityDAO.getAllAbilities()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createAbility(ability: Ability){
        abilityDAO.addAbility(ability)
    }
}