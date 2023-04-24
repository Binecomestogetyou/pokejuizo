package com.bine.pokejuizo.trainer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bine.pokejuizo.DataBase
import com.bine.pokejuizo.PokeRoleApplication
import com.bine.pokejuizo.R
import com.bine.pokejuizo.Score
import com.bine.pokejuizo.nature.NatureViewModel
import com.bine.pokejuizo.nature.NatureViewModelFactory
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
/*
    TODO: separate the code. Initializations and member alterations must not mix
 */

class NewTrainerActivity : AppCompatActivity() {

    private val natureViewModel: NatureViewModel by viewModels {
        NatureViewModelFactory((application as PokeRoleApplication).natureRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_trainer)

        val textName = findViewById<EditText>(R.id.ANTETTrainersName)

        val spinnerAge = findViewById<Spinner>(R.id.ANTSAge)

        val spinnerRank = findViewById<Spinner>(R.id.ANTSRank)

        val spinnerNature = findViewById<Spinner>(R.id.ANTSNature)

        val money = findViewById<EditText>(R.id.ANT_ET_MONEY)

        val et_STR = findViewById<Score>(R.id.ANT_S_STR)

        val et_DEX = findViewById<Score>(R.id.ANT_S_DEX)

        val et_VIT = findViewById<Score>(R.id.ANT_S_VIT)

        val et_INS = findViewById<Score>(R.id.ANT_S_INS)

        money.setText("1500.00")

        val saveButton = findViewById<Button>(R.id.ANTBCreate)


        saveButton.setOnClickListener{

            val trainer = Trainer()

            trainer.name = if (TextUtils.isEmpty(textName.text)) "" else textName.text.toString()
            trainer.Age = spinnerAge.selectedItem.toString()
            trainer.Rank = spinnerRank.selectedItem.toString()
            trainer.Nature = spinnerNature.selectedItem.toString()

            for(nature in (natureViewModel.allNatures.value)!!) if(trainer.Nature == nature.name) trainer.confidence = nature.confidence

            trainer.money = money.text.toString().toFloat()

            trainer.Strength = et_STR.text.toInt()

            trainer.Dexterity = et_DEX.text.toInt()

            trainer.Vitality = et_VIT.text.toInt()

            trainer.Insight = et_INS.text.toInt()

            trainer.hp = trainer.Vitality + 4

            trainer.will = trainer.Insight + 2



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

