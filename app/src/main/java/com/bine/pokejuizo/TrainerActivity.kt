package com.bine.pokejuizo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TrainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer)

        var trainer = Trainer()

        // Exhibiting the retrieved information

        findViewById<TextView>(R.id.ATTVName).text = trainer.Name
        findViewById<TextView>(R.id.ATTVAge).text = trainer.Age
        findViewById<TextView>(R.id.ATTVRank).text = trainer.Rank
       // findViewById<TextView>(R.id.ATTVConcept).text = trainer.TrainersConcept
        findViewById<TextView>(R.id.ATTVNature).text = trainer.Nature
        //findViewById<TextView>(R.id.ATTVConfidence).text = trainer.Confidence.toString()
       // findViewById<TextView>(R.id.ATTVMoney).text = trainer.Money.toString()

    }
}