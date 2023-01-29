package com.bine.pokejuizo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bine.pokejuizo.trainer.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString


class MainActivity : AppCompatActivity() {

    private val newTrainerActivityRequestCode = 1

    private val trainerViewModel: TrainerViewModel by viewModels {
        TrainerViewModelFactory((application as PokeRoleApplication).trainerRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurando a recycler view

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_recycler_view)

        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = linearLayoutManager

        val adapter = TrainersAdapter()

        recyclerView.adapter = adapter

        trainerViewModel.allTrainers.observe(this) { trainers ->
            // Update the cached copy of the words in the adapter.
            trainers?.let { adapter.submitList(it) }
        }



        // Configurando a Bottom Navigation View
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.bottom_navigation_item_traniner

        bottomNavigationView.setOnNavigationItemSelectedListener {

                when(it.itemId) {
                    R.id.bottom_navigation_item_traniner -> true

                    R.id.bottom_navigation_item_library -> {
                        startActivity(Intent(applicationContext, LibraryActivity::class.java))
                        overridePendingTransition(0, 0)
                        return@setOnNavigationItemSelectedListener true
                    }

                    R.id.bottom_navigation_item_settings -> {
                        startActivity(Intent(applicationContext, SettingsActivity::class.java))
                        overridePendingTransition(0, 0)
                        return@setOnNavigationItemSelectedListener true
                    }

                    else -> false
                }
        }
    }

    fun onClickOnFAB(view: View){

        startActivityForResult(Intent(this, NewTrainerActivity::class.java), newTrainerActivityRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newTrainerActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewTrainerActivity.EXTRA_REPLY)?.let { reply ->
                val trainer = Json.decodeFromString<Trainer>(reply)

                var id = 0

                while(!trainerViewModel.idIsVacant(Char(id).toString())) id++

                trainer.id = Char(id).toString()

                trainerViewModel.insert(trainer)
            }
        }
    }
}