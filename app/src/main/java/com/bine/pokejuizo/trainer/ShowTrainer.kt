package com.bine.pokejuizo.trainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bine.pokejuizo.R
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ShowTrainer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_trainer)

        val trainer = Json.decodeFromString<Trainer>(intent.getStringExtra("TRAINER")!!)

        findViewById<TextView>(R.id.ST_TV_NAME).text = trainer.name
        findViewById<TextView>(R.id.ST_TV_AGE).text = trainer.age
        findViewById<TextView>(R.id.ST_TV_RANK).text = trainer.rank
        findViewById<TextView>(R.id.ST_TV_NATURE).text = trainer.nature
        findViewById<TextView>(R.id.ST_TV_CONFIDENCE).text = trainer.confidence.toString()
    }
}