package com.bine.pokejuizo.item

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "items")
class Item() {

    lateinit var name : String
 /*   lateinit var description : String
    lateinit var typeBonus : String
    var value = 0
    lateinit var specificPokemon : String
    lateinit var healAmount : String
    var suggestedPrice = 0.0f
    var pmdPrice = 0.0f*/
    lateinit var json: String

    @PrimaryKey
    @NonNull
    lateinit var id : String

    constructor(jsonString : String) : this() {

        this.json = jsonString

        val jObject = JSONObject(jsonString)

        this.id = jObject.getString("_id")
        this.name = jObject.getString("Name")
   /*     this.description = jObject.getString("Description")
        this.typeBonus = jObject.getString("TypeBonus")
        this.value = jObject.getInt("Value")
        this.specificPokemon = jObject.getString("SpecificPokemon")
        this.healAmount = jObject.getString("HealAmount")
        this.suggestedPrice = jObject.getDouble("SuggestedPrice").toFloat()
        this.pmdPrice = jObject.getDouble("PMDPrice").toFloat()*/
    }
}