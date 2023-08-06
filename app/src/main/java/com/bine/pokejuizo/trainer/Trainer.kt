package com.bine.pokejuizo.trainer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "trainers")
@Serializable
class Trainer{

    companion object {

        @Ignore
        val natures = mapOf(
                "adamant" to 4,
                "serious" to 4,
                "timid" to 4,
                "careful" to 5,
                "lonely" to 5,
                "quiet" to 5,
                "bashful" to 6,
                "naughty" to 6,
                "rash" to 6,
                "docile" to 7,
                "hasty" to 7,
                "impish" to 7,
                "naive" to 7,
                "sassy" to 7,
                "calm" to 8,
                "lax" to 8,
                "mild" to 8,
                "relaxed" to 8,
                "bold" to 9,
                "brave" to 9,
                "hardy" to 9,
                "quirky" to 9,
                "gentle" to 1,
                "jolly" to 10,
                "modest" to 10)

        @Ignore
        val achievs = mapOf(
                "starter" to listOf("Successfully understand your Pokémon's gestures",
                                    "Train a Pokémon",
                                    "Catch your second Pokémon",
                                    "Win your first Official Battle against a Trainer"),
                "beginner" to listOf("Evolve a Pokémon",
                                     "Win your First Badge",
                                     "Increase a Pokémon’s Loyalty & Happiness"),
                "amateur" to listOf("Win 8 Badges",
                                    "Get a full party of six evolved Pokémon",
                                    "Defeat your Rival"),
                "ace" to listOf("Get a Pokémon-related job",
                                "Clear the Victory Road",
                                "Catch a Professional-Rank Pokémon"),
                "pro" to listOf("Find and study all Pokémon species in your Region"),
                "master" to listOf("Defeat the Champion in the League's Challenge")
        )
    }

    @PrimaryKey
    var id: String = "" // Leave this property as a String 'cause using Int will be hellish

    @ColumnInfo(name = "name")
    lateinit var name : String
    lateinit var age : String
    var rank : String = "starter"
        set(value) {
            field = value

            if(value != "champion") achievements = achievs[value]!!.map { str -> Pair(str, false) }
        }
    lateinit var concept : String
    var nature : String = ""
    set(value) {
        field = value
        confidence = natures[value]!!
    }

    ///////////
    // Trainer's card window
    ///////////
    @ColumnInfo(name = "confidence")
    var confidence = 500
    var money = 0f
    var hp = 0
    var will = 0
    var activeParty: MutableList<String>? = null
    var achievements : List<Pair<String, Boolean>>? = null

    var strength = 0
    var dexterity = 0
    var vitality = 0
        set(value) {
            field = value
            hp = value + 4
        }
    var insight = 0
        set(value) {
            field = value
            will = value + 2
        }

    var tough = 0
    var cool = 0
    var beauty = 0
    var clever = 0
    var cute = 0

    var brawl = 0
    var throwSkill = 0
    var evasion = 0
    var weapons = 0

    var alert = 0
    var athletic = 0
    var natureSkill = 0
    var stealth = 0

    var allure  = 0
    var etiquette = 0
    var intimidate = 0
    var perform = 0

    var crafts = 0
    var lore = 0
    var medicine = 0
    var science = 0

    var pokemonCaught = 0
    var pokemonSeen = 0

    var mainPocket : MutableList<String>? = null
    var itemPocket : MutableList<String>? = null

    var potions : MutableList<Pair<Int, Int>>? = null

    var badges : Array<String> = Array(8) { "" }
}