package com.bine.pokejuizo.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bine.pokejuizo.R
import com.bine.pokejuizo.ability.Ability

class ShowPokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_pokemon)

        val pokemon = Pokemon(intent.getStringExtra("Pokemon")!!)

        findViewById<TextView>(R.id.ASP_TV_NAME).text = pokemon.name
    }
}