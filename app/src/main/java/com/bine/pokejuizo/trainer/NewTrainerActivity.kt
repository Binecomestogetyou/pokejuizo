package com.bine.pokejuizo.trainer

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.text.TextUtils
import android.util.TypedValue
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

val Number.toPx get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this.toFloat(),
    Resources.getSystem().displayMetrics)

class NewTrainerActivity : AppCompatActivity() {

    private val natureViewModel : NatureViewModel by viewModels {
        NatureViewModelFactory((application as PokeRoleApplication).natureRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_trainer)

        val textName = findViewById<EditText>(R.id.ANT_ET_NAME).also { it.background = ContextCompat.getDrawable(this, R.drawable.white_bordered_round_rect) }

        val textConcept = findViewById<EditText>(R.id.ANT_ET_CONCEPT).also { it.background = ContextCompat.getDrawable(this, R.drawable.white_bordered_round_rect) }

        val spinnerAge = findViewById<Spinner>(R.id.ANT_SPI_AGE).also { it.background = ContextCompat.getDrawable(this, R.drawable.white_bordered_round_rect) }

        val spinnerRank = findViewById<Spinner>(R.id.ANT_SPI_RANK).also { it.background = ContextCompat.getDrawable(this, R.drawable.white_bordered_round_rect) }

        val spinnerNature = findViewById<Spinner>(R.id.ANT_SPI_NATURE).also { it.background = ContextCompat.getDrawable(this, R.drawable.white_bordered_round_rect) }

        val spinnerAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, natureViewModel.getAllNames())
        spinnerAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        spinnerNature.adapter = spinnerAdapter

        val money = findViewById<EditText>(R.id.ANT_ET_MONEY).also { it.background = ContextCompat.getDrawable(this, R.drawable.white_bordered_round_rect) }

        val strength = findViewById<Score>(R.id.ANT_SCO_STR)

        val dexterity = findViewById<Score>(R.id.ANT_SCO_DEX)

        val vitality = findViewById<Score>(R.id.ANT_SCO_VIT)

        val insight = findViewById<Score>(R.id.ANT_SCO_INS)

        val tough = findViewById<Score>(R.id.ANT_SCO_TOUGH)

        val cool = findViewById<Score>(R.id.ANT_SCO_COOL)

        val beauty = findViewById<Score>(R.id.ANT_SCO_BEAUTY)

        val clever = findViewById<Score>(R.id.ANT_SCO_CLEVER)

        val cute = findViewById<Score>(R.id.ANT_SCO_CUTE)

        val brawl = findViewById<Score>(R.id.ANT_SCO_BRAWL)

        val _throw = findViewById<Score>(R.id.ANT_SCO_THROW)

        val evasion = findViewById<Score>(R.id.ANT_SCO_EVASION)

        val weapons = findViewById<Score>(R.id.ANT_SCO_WEAPONS)

        val alert = findViewById<Score>(R.id.ANT_SCO_ALERT)

        val athletic = findViewById<Score>(R.id.ANT_SCO_ATHLETIC)

        val nature = findViewById<Score>(R.id.ANT_SCO_NATURE)

        val stealth = findViewById<Score>(R.id.ANT_SCO_STEALTH)

        val allure = findViewById<Score>(R.id.ANT_SCO_ALLURE)

        val ettiquete = findViewById<Score>(R.id.ANT_SCO_ETTIQUETE)

        val intimidate = findViewById<Score>(R.id.ANT_SCO_INTIMIDATE)

        val performance = findViewById<Score>(R.id.ANT_SCO_PERFORM)

        val crafts = findViewById<Score>(R.id.ANT_SCO_CRAFTS)

        val lore = findViewById<Score>(R.id.ANT_SCO_LORE)

        val medicine = findViewById<Score>(R.id.ANT_SCO_MEDICINE)

        val science = findViewById<Score>(R.id.ANT_SCO_SCIENCE)

        money.setText("1500.00")

        val saveButton = findViewById<Button>(R.id.ANTBCreate)

        saveButton.setOnClickListener{


                val trainer = Trainer()

                trainer.name =
                    if (TextUtils.isEmpty(textName.text)) "" else textName.text.toString()
                trainer.age = spinnerAge.selectedItem.toString()
                trainer.rank = spinnerRank.selectedItem.toString()
                trainer.nature = spinnerNature.selectedItem.toString()

                trainer.concept = if(TextUtils.isEmpty(textConcept.text)) "" else textConcept.text.toString()

                trainer.money = money.text.toString().toFloat()

                trainer.strength = strength.getLevel()
                trainer.strength = strength.getLevel()

                trainer.dexterity = dexterity.getLevel()

                trainer.vitality = vitality.getLevel()

                trainer.insight = insight.getLevel()

                trainer.tough = tough.getLevel()

                trainer.cool = cool.getLevel()

                trainer.beauty = beauty.getLevel()

                trainer.clever = clever.getLevel()

                trainer.cute = cute.getLevel()

                trainer.brawl = brawl.getLevel()

                trainer.throwSkill = _throw.getLevel()

                trainer.evasion = evasion.getLevel()

                trainer.weapons = weapons.getLevel()

                trainer.alert = alert.getLevel()

                trainer.athletic = athletic.getLevel()

                trainer.natureSkill = nature.getLevel()

                trainer.stealth = stealth.getLevel()

                trainer.allure = allure.getLevel()

                trainer.etiquette = ettiquete.getLevel()

                trainer.intimidate = intimidate.getLevel()

                trainer.perform = performance.getLevel()

                trainer.crafts = crafts.getLevel()

                trainer.lore = lore.getLevel()

                trainer.medicine = medicine.getLevel()

                trainer.science = science.getLevel()

                val intent = Intent(this, ShowTrainer::class.java)

                intent.putExtra("TRAINER", Json.encodeToString(trainer))


                startActivity(intent)
                finish()
        }
    }
}

