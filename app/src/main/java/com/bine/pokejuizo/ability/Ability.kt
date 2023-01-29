package com.bine.pokejuizo.ability

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "abilities")
class Ability(){

    lateinit var name : String
    lateinit var effect : String
    lateinit var description : String
    lateinit var json : String

    @PrimaryKey
    @NonNull
    lateinit var id : String


    constructor(jsonString : String) : this(){

        this.json = jsonString

        val jsonObject = JSONObject(jsonString)

        this.name = jsonObject.getString("Name")
        this.effect = jsonObject.getString("Effect")
        this.description = jsonObject.getString("Description")
        this.id = jsonObject.getString("_id")
    }

    override fun toString(): String {
        return name+effect+description+id
    }
}