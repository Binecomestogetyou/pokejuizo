package com.bine.pokejuizo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class NewTrainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_trainer)

        val textName = findViewById<EditText>(R.id.ANTETTrainersName)

        val spinnerAge = findViewById<Spinner>(R.id.ANTSAge)

        val spinnerRank = findViewById<Spinner>(R.id.ANTSRank)

        val spinnerNature = findViewById<Spinner>(R.id.ANTSNature)


        val saveButton = findViewById<Button>(R.id.ANTBCreate)


        saveButton.setOnClickListener{

            val trainer = Trainer()

            trainer.Name = if (TextUtils.isEmpty(textName.text)) "" else textName.text.toString()
            trainer.Age = spinnerAge.selectedItem.toString()
            trainer.Rank = spinnerRank.selectedItem.toString()
            trainer.Nature = spinnerNature.selectedItem.toString()

            val intent = Intent()

            intent.putExtra(EXTRA_REPLY, Json.encodeToString(trainer))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    companion object{

        const val EXTRA_REPLY = "com.bine.pokejuizo.trainerextra"
    }
}

