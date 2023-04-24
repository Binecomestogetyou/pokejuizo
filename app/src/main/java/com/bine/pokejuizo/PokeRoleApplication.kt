package com.bine.pokejuizo

import android.app.Application
import com.bine.pokejuizo.ability.AbilityRepository
import com.bine.pokejuizo.item.ItemRepository
import com.bine.pokejuizo.learnset.LearnsetRepository
import com.bine.pokejuizo.move.MoveRepository
import com.bine.pokejuizo.nature.NatureRepository
import com.bine.pokejuizo.pokemon.PokemonRepository
import com.bine.pokejuizo.trainer.TrainerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PokeRoleApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val dataBase by lazy { DataBase.getDataBase(this, applicationScope) }
    val trainerRepository by lazy { TrainerRepository(dataBase.trainerDAO()) }
    val pokemonRepository by lazy {PokemonRepository(dataBase.pokemonDAO())}
    val abilityRepository by lazy { AbilityRepository(dataBase.abilityDAO()) }
    val itemRepository by lazy { ItemRepository(dataBase.itemDAO()) }
    val moveRepository by lazy { MoveRepository(dataBase.moveDAO()) }
    val natureRepository by lazy { NatureRepository(dataBase.natureDAO()) }
    val learnsetRepository by lazy { LearnsetRepository(dataBase.learnsetDAO()) }
}