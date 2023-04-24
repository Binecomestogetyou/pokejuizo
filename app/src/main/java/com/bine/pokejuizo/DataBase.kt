package com.bine.pokejuizo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bine.pokejuizo.ability.Ability
import com.bine.pokejuizo.ability.AbilityDAO
import com.bine.pokejuizo.item.Item
import com.bine.pokejuizo.item.ItemDAO
import com.bine.pokejuizo.learnset.Learnset
import com.bine.pokejuizo.learnset.LearnsetDAO
import com.bine.pokejuizo.move.Move
import com.bine.pokejuizo.move.MoveDAO
import com.bine.pokejuizo.nature.Nature
import com.bine.pokejuizo.nature.NatureDAO
import com.bine.pokejuizo.pokemon.Pokemon
import com.bine.pokejuizo.pokemon.PokemonDAO
import com.bine.pokejuizo.trainer.Trainer
import com.bine.pokejuizo.trainer.TrainerDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader

@Database(version = 1, entities = [Trainer::class, Ability::class, Item::class, Move::class, Nature::class, Learnset::class, Pokemon::class], exportSchema = false)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {

    abstract fun trainerDAO() : TrainerDAO
    abstract fun abilityDAO() : AbilityDAO
    abstract fun itemDAO() : ItemDAO
    abstract fun moveDAO() : MoveDAO
    abstract fun natureDAO() : NatureDAO
    abstract fun learnsetDAO() : LearnsetDAO
    abstract fun pokemonDAO() : PokemonDAO


    companion object{

        private const val dbName = "pokejuizoDB"

        private var instance : DataBase? = null

        fun getDataBase(context : Context, scope: CoroutineScope) : DataBase {

            return instance ?: synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    dbName
                ).addCallback(DatabaseCallback(context, scope))
                    .build()
                instance = inst
                // return inst
                inst
            }
        }
    }

    private class DatabaseCallback(
        val context: Context,
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            instance?.let { database ->
                scope.launch {
                    populateDatabase(database.abilityDAO(),
                        database.itemDAO(),
                        database.moveDAO(),
                        database.natureDAO(),
                        database.learnsetDAO(),
                        database.pokemonDAO())
                }
            }
        }

        suspend fun populateDatabase(abilityDAO: AbilityDAO,
                                     itemDAO: ItemDAO,
                                     moveDAO: MoveDAO,
                                     natureDAO: NatureDAO,
                                     learnsetDAO: LearnsetDAO,
                                     pokemonDAO: PokemonDAO) {

            var fileList = context.assets.list("abilities/")

            for(ja in fileList!!){

                val reader = BufferedReader(
                    InputStreamReader(context.assets.open("abilities/$ja"))
                )

                abilityDAO.addAbility(Ability(reader.readText()))

                reader.close()
            }



            fileList = context.assets.list("items/")

            for(ja in fileList!!){

                val reader = BufferedReader(
                    InputStreamReader(context.assets.open("items/$ja"))
                )

                itemDAO.addItem(Item(reader.readText()))

                reader.close()
            }



            fileList = context.assets.list("moves/")

            for(ja in fileList!!){

                val reader = BufferedReader(
                    InputStreamReader(context.assets.open("moves/$ja"))
                )

                moveDAO.addMove(Move(reader.readText()))

                reader.close()
            }



            fileList = context.assets.list("natures/")

            for(ja in fileList!!){

                val reader = BufferedReader(
                    InputStreamReader(context.assets.open("natures/$ja"))
                )

                natureDAO.addNature(Nature(reader.readText()))

                reader.close()
            }



            fileList = context.assets.list("learnsets/")

            for(ja in fileList!!){

                val reader = BufferedReader(
                    InputStreamReader(context.assets.open("learnsets/$ja"))
                )

                learnsetDAO.addLearnset(Learnset(reader.readText()))

                reader.close()
            }

            fileList = context.assets.list("pokedex/")

            for(ja in fileList!!){

                val reader = BufferedReader(
                    InputStreamReader(context.assets.open("pokedex/$ja"))
                )

                pokemonDAO.addPokemon(Pokemon(reader.readText()))

                reader.close()
            }
        }
    }
}