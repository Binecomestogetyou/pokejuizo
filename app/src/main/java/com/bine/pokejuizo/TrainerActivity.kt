package com.bine.pokejuizo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bine.pokejuizo.trainer.NewTrainerActivity
import com.bine.pokejuizo.trainer.TrainerViewModel
import com.bine.pokejuizo.trainer.TrainerViewModelFactory
import com.bine.pokejuizo.trainer.TrainersAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


class TrainerActivity : AppCompatActivity() {

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

        bottomNavigationView.selectedItemId = R.id.bottom_navigation_item_trainer

        bottomNavigationView.setOnNavigationItemSelectedListener {

                when(it.itemId) {
                    R.id.bottom_navigation_item_trainer -> true

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

        startActivity(Intent(this, NewTrainerActivity::class.java))
    }
}