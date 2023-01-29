package com.bine.pokejuizo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bine.pokejuizo.ability.Ability
import com.bine.pokejuizo.ability.AbilityDAO
import com.bine.pokejuizo.trainer.Trainer
import com.bine.pokejuizo.trainer.TrainerDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader

@Database(version = 2, entities = [Trainer::class, Ability::class], exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun trainerDAO() : TrainerDAO
    abstract fun abilityDAO() : AbilityDAO


    companion object{

        private const val dbName = "pokejuizoDB"

        private var instance : DataBase? = null

        fun getDataBase(context : Context, scope: CoroutineScope) : DataBase {

            return instance ?: synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    dbName
                ).addCallback(AbilityDatabaseCallback(context, scope))
                    .build()
                instance = inst
                // return inst
                inst
            }
        }
    }

    private class AbilityDatabaseCallback(
        val context: Context,
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            instance?.let { database ->
                scope.launch {
                    populateDatabase(database.abilityDAO())
                }
            }
        }

        suspend fun populateDatabase(abilityDAO: AbilityDAO) {

            println("PopulateDatabase was called")

            val jsonabilities = context.assets.list("abilities/")

            for(ja in jsonabilities!!){

                val reader = BufferedReader(
                    InputStreamReader(context.assets.open("abilities/${ja}"))
                )

                abilityDAO.addAbility(Ability(reader.readText()))
            }
        }
    }
}