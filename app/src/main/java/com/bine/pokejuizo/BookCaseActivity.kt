package com.bine.pokejuizo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bine.pokejuizo.ability.AbilitiesAdapter
import com.bine.pokejuizo.ability.AbilityViewModel
import com.bine.pokejuizo.ability.AbilityViewModelFactory

class BookCaseActivity : AppCompatActivity() {

    private val abilityViewModel: AbilityViewModel by viewModels {
        AbilityViewModelFactory((application as PokeRoleApplication).abilityRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_case)

        val recyclerView = findViewById<RecyclerView>(R.id.BC_RV)

        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        linearLayoutManager.also { recyclerView.layoutManager = it }

        when(intent.getStringExtra("BOOKCASE")) {

            "Abilities" -> {

                println("Found abilitites")

                val adapter = AbilitiesAdapter()

                recyclerView.adapter = adapter

                abilityViewModel.allAbilities.observe(this) { abilities ->

                    abilities?.let { adapter.submitList(it) }
                }
            }
        }
    }
}