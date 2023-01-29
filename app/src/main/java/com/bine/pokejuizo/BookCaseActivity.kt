package com.bine.pokejuizo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bine.pokejuizo.ability.AbilitiesAdapter
import com.bine.pokejuizo.ability.AbilityViewModel
import com.bine.pokejuizo.ability.AbilityViewModelFactory
import com.bine.pokejuizo.item.ItemViewModel
import com.bine.pokejuizo.item.ItemViewModelFactory
import com.bine.pokejuizo.item.ItemAdapter

class BookCaseActivity : AppCompatActivity() {

    private val abilityViewModel: AbilityViewModel by viewModels {
        AbilityViewModelFactory((application as PokeRoleApplication).abilityRepository)
    }

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as PokeRoleApplication).itemRepository)
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

                val adapter = AbilitiesAdapter()

                recyclerView.adapter = adapter

                abilityViewModel.allAbilities.observe(this) { abilities ->

                    abilities?.let { adapter.submitList(it) }
                }
            }

            "Items" -> {

                val adapter = ItemAdapter()

                recyclerView.adapter = adapter

                itemViewModel.allItems.observe(this) { items ->

                    items?.let { adapter.submitList(it) }
                }
            }
        }
    }
}