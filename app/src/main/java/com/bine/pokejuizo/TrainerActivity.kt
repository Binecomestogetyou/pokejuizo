package com.bine.pokejuizo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson

class TrainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer)

        // Retrieve Trainer object sent by calling activity
        val sharedPrefs = getSharedPreferences(getString(R.string.com_bine_pokejuizo_shared_preferences_trainers), Context.MODE_PRIVATE)
        val key = intent.getIntExtra("trainerkey", 0)
        val json = sharedPrefs.getString("trainer${key}", "")!!

        var trainer = (Gson()).fromJson(json, Trainer::class.java)

        // Exhibiting the retrieved information

        findViewById<TextView>(R.id.ATTVName).text = trainer.Name
        findViewById<TextView>(R.id.ATTVAge).text = trainer.Age
        findViewById<TextView>(R.id.ATTVRank).text = trainer.Rank
        findViewById<TextView>(R.id.ATTVConcept).text = trainer.TrainersConcept
        findViewById<TextView>(R.id.ATTVNature).text = trainer.Nature
        findViewById<TextView>(R.id.ATTVConfidence).text = trainer.Confidence.toString()
        findViewById<TextView>(R.id.ATTVMoney).text = trainer.Money.toString()

    }
}