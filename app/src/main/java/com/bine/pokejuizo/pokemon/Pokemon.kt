package com.bine.pokejuizo.pokemon

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "pokedex")
class Pokemon() {

    lateinit var name : String
    lateinit var json : String

    @PrimaryKey
    @NonNull
    lateinit var id : String

    constructor(jsonString : String) : this() {

        this.json = jsonString

        val jsonObject = JSONObject(jsonString)

        this.id = jsonObject.getString("DexID")

        this.name = jsonObject.getString("Name")
    }
}