package com.bine.pokejuizo.trainer

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import kotlin.collections.ArrayList


@Entity(tableName = "trainers")
@Serializable
class Trainer (){

    constructor(name : String, age : String, rank : String, nature : String) : this(){

        this.name = name
        this.age = age
        this.rank = rank
        this.nature = nature
    }

    @PrimaryKey
    @NonNull
    var id: String = "" // Leave this property as a String 'cause using Int will be hellish

    @ColumnInfo(name = "name")
    lateinit var name : String
    lateinit var age : String
    lateinit var rank : String
    lateinit var concept : String
    lateinit var nature : String

    ///////////
    // Trainer's card window
    ///////////
    @ColumnInfo(name = "confidence")
    var confidence = 500
    var money = 0f
    var hp = 0
    var will = 0
    //var TrainersActiveParty: LinkedList<Pokemon?>? = null

    var characteristics : MutableList<Pair<String, Int>> = ArrayList()
    set(value) {}

    fun getValue(str : String) : Int {

        for(c in characteristics) if(c.first == str) return c.second

        return -10
    }
}