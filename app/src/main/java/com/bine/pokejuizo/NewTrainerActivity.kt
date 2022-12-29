package com.bine.pokejuizo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import com.google.gson.Gson


class NewTrainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_trainer)

        //TextWatcher // https://stackoverflow.com/questions/10699202/how-to-change-textviews-text-on-change-of-edittexts-text
    }

    fun gravarTreinador(view : View){

        val novo = Trainer(findViewById<EditText>(R.id.ANTETTrainersName).text.toString(),
                            findViewById<Spinner>(R.id.ANTSAge).selectedItem.toString(),
                            findViewById<Spinner>(R.id.ANTSRank).selectedItem.toString(),
                            findViewById<EditText>(R.id.ANTETTrainersConcept).text.toString(),
                            findViewById<Spinner>(R.id.ANTSNature).selectedItem.toString())

       // var te

        val sharedPref = getSharedPreferences(getString(R.string.com_bine_pokejuizo_shared_preferences_trainers), Context.MODE_PRIVATE) ?: return

        with (sharedPref.edit()) {
            putString("trainer${sharedPref.all.size}", (Gson()).toJson(novo))
            apply()
        }

        val intent = Intent(this, TrainerActivity::class.java)
        intent.putExtra("trainerkey", sharedPref.all.size - 1)

        startActivity(intent)
    }
}

