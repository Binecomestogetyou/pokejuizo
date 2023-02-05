package com.bine.pokejuizo.move

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "moves")
class Move() {

    lateinit var name : String
    lateinit var type : String
    lateinit var dmgType : String
    var power = 0
    lateinit var damage1 : String
    lateinit var damage2 : String
    lateinit var accuracy1 : String
    lateinit var accuracy2 : String
    lateinit var target : String
    lateinit var description : String
    lateinit var effect : String
    lateinit var json: String

    @PrimaryKey
    @NonNull
    lateinit var id : String

    constructor(jstring : String) : this(){

        this.json = jstring

        val json =  JSONObject(jstring)

        this.id = json.getString("_id")
        this.name = json.getString("Name")
        this.type = json.getString("Type")
        this.dmgType = json.getString("DmgType")
        this.power = json.getInt("Power")
        this.damage1 = json.getString("Damage1")
        this.damage2 = json.getString("Damage2")
        this.accuracy1 = json.getString("Accuracy1")
        this.accuracy2 = json.getString("Accuracy2")
        this.target = json.getString("Target")
        this.description = json.getString("Description")
        this.effect = json.getString("Effect")
    }
}