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

        //val trainer = Json.decodeFromString<Trainer>(intent.getStringExtra("TRAINER")!!)

        findViewById<TextView>(R.id.ST_TV_NAME).text = "Placeholder"
        findViewById<TextView>(R.id.ST_TV_AGE).text = "PlaceHolder"
        findViewById<TextView>(R.id.ST_TV_RANK).text = "somerank"
        findViewById<TextView>(R.id.ST_TV_CONCEPT).text = "issoai"
        findViewById<TextView>(R.id.AST_TV_NATURE).text = "Adamant"
        findViewById<TextView>(R.id.AST_TV_CONFIDENCE).text = "4"
        findViewById<TextView>(R.id.AST_TV_MONEY).text = String.format("%.2f", 1500f)
    }
}