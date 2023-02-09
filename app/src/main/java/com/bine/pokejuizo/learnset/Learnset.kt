package com.bine.pokejuizo.learnset

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject
import kotlin.system.exitProcess

@Entity(tableName = "learnsets")
class Learnset() {

    lateinit var name : String
    lateinit var moves : MutableList<Pair<String, String>>
    lateinit var json : String

    @PrimaryKey
    @NonNull
    lateinit var id : String

    constructor(jstring : String) : this() {

        json = jstring

        val jobject = JSONObject(jstring)

        name = jobject.getString("Name")
        id = jobject.getString("_id")

        moves = ArrayList()

        val jarray = jobject.getJSONArray("Moves")

        for(i in 0 until jarray.length()){

            val jo = jarray.get(i) as JSONObject

            moves.add(Pair(jo.getString("Learned"), jo.getString("Name")))
        }
    }
}