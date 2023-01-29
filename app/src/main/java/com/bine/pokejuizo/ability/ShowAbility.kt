package com.bine.pokejuizo.ability

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bine.pokejuizo.R

class ShowAbility : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_ability)

        val ability = Ability(intent.getStringExtra("Ability")!!)

        findViewById<TextView>(R.id.SA_TV_name).text = ability.name
        findViewById<TextView>(R.id.SA_TV_effect).text = ability.effect
        findViewById<TextView>(R.id.SA_TV_description).text = ability.description
    }
}