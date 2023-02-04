package com.bine.pokejuizo.item

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "items")
class Item() {

    lateinit var name : String
    lateinit var json: String
    lateinit var description : String

    @PrimaryKey
    @NonNull
    lateinit var id : String

    constructor(jsonString : String) : this() {

        this.json = jsonString

        val jObject = JSONObject(jsonString)

        this.id = jObject.getString("_id")
        this.name = jObject.getString("Name")
        this.description = jObject.getString("Description")
    }
}