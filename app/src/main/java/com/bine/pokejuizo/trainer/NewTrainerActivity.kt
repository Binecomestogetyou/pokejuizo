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

                trainer.confidence = natureViewModel.getConfidence(trainer.nature)

                trainer.money = money.text.toString().toFloat()

                trainer.characteristics.add(Pair(strength.text, strength.getLevel()))

                trainer.characteristics.add(Pair(dexterity.text, dexterity.getLevel()))

                trainer.characteristics.add(Pair(vitality.text, vitality.getLevel()))

                trainer.characteristics.add(Pair(insight.text, insight.getLevel()))

                trainer.hp = trainer.getValue(resources.getString(R.string.Vitalidade)) + 4

                trainer.will = trainer.getValue(resources.getString(R.string.Intuição)) + 2

                trainer.characteristics.add(Pair(tough.text, tough.getLevel()))

                trainer.characteristics.add(Pair(cool.text, cool.getLevel()))

                trainer.characteristics.add(Pair(beauty.text, beauty.getLevel()))

                trainer.characteristics.add(Pair(clever.text, clever.getLevel()))

                trainer.characteristics.add(Pair(cute.text, cute.getLevel()))

                trainer.characteristics.add(Pair(brawl.text, brawl.getLevel()))

                trainer.characteristics.add(Pair(_throw.text, _throw.getLevel()))

                trainer.characteristics.add(Pair(evasion.text, evasion.getLevel()))

                trainer.characteristics.add(Pair(weapons.text, weapons.getLevel()))

                trainer.characteristics.add(Pair(alert.text, alert.getLevel()))

                trainer.characteristics.add(Pair(athletic.text, athletic.getLevel()))

                trainer.characteristics.add(Pair(nature.text, nature.getLevel()))

                trainer.characteristics.add(Pair(stealth.text, stealth.getLevel()))

                trainer.characteristics.add(Pair(allure.text, allure.getLevel()))

                trainer.characteristics.add(Pair(ettiquete.text, ettiquete.getLevel()))

                trainer.characteristics.add(Pair(intimidate.text, intimidate.getLevel()))

                trainer.characteristics.add(Pair(performance.text, performance.getLevel()))

                trainer.characteristics.add(Pair(crafts.text, crafts.getLevel()))

                trainer.characteristics.add(Pair(lore.text, lore.getLevel()))

                trainer.characteristics.add(Pair(medicine.text, medicine.getLevel()))

                trainer.characteristics.add(Pair(science.text, science.getLevel()))

                val intent = Intent(this, ShowTrainer::class.java)

                intent.putExtra("TRAINER", Json.encodeToString(trainer))


                startActivity(intent)
                finish()
        }
    }
}

