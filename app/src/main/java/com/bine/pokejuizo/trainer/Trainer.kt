package com.bine.pokejuizo.trainer

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.*


@Entity(tableName = "trainers")
@Serializable
class Trainer (){

    constructor(name : String, age : String, rank : String, nature : String) : this(){

        this.name = name
        this.Age = age
        this.Rank = rank
        this.Nature = nature
    }

    @PrimaryKey
    @NonNull
    var id: String = "" // Leave this property as a String 'cause using Int will be hellish

    lateinit var name : String
    lateinit var Age : String
    lateinit var Rank : String
  //  lateinit var TrainersConcept : String
    lateinit var Nature : String

    ///////////
    // Trainer's card window
    ///////////
    var confidence = 0
    var money = 0f
    var hp = 0
    var will = 0
    //var TrainersActiveParty: LinkedList<Pokemon?>? = null

    /////////
    // Attributes and skills window
    /////////
    // Attributes
    var Strength = 0
    var Dexterity = 0
    var Vitality = 0
    var Insight = 0
/*
    // Social attributes
    var Tough = 0
    var Cool = 0
    var Beauty = 0
    var Clever = 0
    var Cute = 0

    // Fight skills
    var Brawl = 0
    var Throw = 0
    var Evasion = 0
    var Weapons = 0

    // Survival skills
    var Alert = 0
    var Athletic = 0
//    var Nature = 0
    var Stealth = 0

    // Social skills
    var Allure = 0
    var Etiquette = 0
    var Intimidate = 0
    var Perform = 0

    // Knowledge skills
    var Crafts = 0
    var Lore = 0
    var Medicine = 0
    var Science = 0

    // Extra skills
    //var ExtraSkills: LinkedList<Skill?>? = null

    // Achievements
    //var Achievements: LinkedList<Achievement?>? = null

    // Pokemon
    var PokemonCaught = 0
    var PokemonSeen = 0

    /////////////////
    // BackPack window
    /////////////////
    // Potions pocket
    //var SimplePotions: SimplePotion? = null
    //var SuperPotions: SuperPotion? = null
    //var HyperPotions: HyperPotion? = null

    // Small pocket
    //var SmallPocketItems: LinkedList<Item?>? = null

    // Main pocket
    //var MainPocketItems: LinkedList<Item?>? = null

    // Gym Badges Case
    //var Badges: LinkedList<Badge?>? = null

    // Auxiliary members
    var attributePoints : Int

    init {

        Confidence = when(Nature){

            "Inflexível" -> 4
            "Tímido" -> 6
            "Corajoso" -> 9
            "Valente" -> 9
            "Calmo" -> 8
            "Cuidadoso" -> 5
            "Dócil" -> 7
            "Gentil" -> 10
            "Resistente" -> 9
            "Apressado" -> 7
            "Travesso" -> 7
            "Alegre" -> 10
            "Descuidado" -> 8
            "Solitário" -> 5
            "Suave" -> 8
            "Modesto" -> 10
            "Ingênuo" -> 7
            "Desobediente" -> 6
            "Quieto" -> 5
            "Peculiar" -> 9
            "Precipitado" -> 6
            "Relaxado" -> 8
            "Atrevido" -> 7
            "Sério" -> 4
            "Inseguro" -> 4
            else -> 0
        }

        Money = 1500f

        attributePoints = when(Age){

                "Criança" -> 0
                "Adolescente" -> 2
                "Adulto" -> 4
                "Sênior" -> 3
            else -> 0
        } +
                when(Rank){

                        "Novato" -> 2
                        "Amador" -> 4
                        "Ás" -> 6
                        "Profissional" -> 8
                    else -> 0
                }
    }*/


}