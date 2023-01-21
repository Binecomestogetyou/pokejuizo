package com.bine.pokejuizo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

@Database(version = 1, entities = [Trainer::class], exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun trainerDAO() : TrainerDAO


    companion object{

        private const val dbName = "TRAINERS"

        private var instance : DataBase? = null

        fun getDataBase(context : Context, scope: CoroutineScope) : DataBase {
            println("getDataBase was called")

            return instance ?: synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    dbName
                ).addCallback(TrainerDatabaseCallback(scope))
                    .build()
                instance = inst
                // return inst
                inst
            }
        }
    }

    private class TrainerDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            instance?.let { database ->
                scope.launch {
                    populateDatabase(database.trainerDAO())
                }
            }
        }

        suspend fun populateDatabase(trainerDAO: TrainerDAO) {
            // Delete all content here.
            trainerDAO.deleteAll()

            // Add sample words.
            val trainer = Trainer("Tutu", "Adult", "Starter", "Cansei")

            trainerDAO.addTrainer(trainer)

            println("Populate database finished")
        }
    }
}