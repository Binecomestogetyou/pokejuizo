package com.bine.pokejuizo.nature

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "natures")
class Nature() {

    lateinit var name : String
    var confidence = 0
    lateinit var description : String
    lateinit var keywords : Array<String>
    lateinit var json : String

    @PrimaryKey
    @NonNull
    lateinit var id : String

    constructor(jsonString: String) : this() {

        json = jsonString

        val jobject = JSONObject(jsonString)

        id = jobject.getString("_id")
        name = jobject.getString("Name")
        confidence = jobject.getInt("Confidence")
        description = jobject.getString("Description")
        keywords = jobject.getString("Keywords").split(Regex(", ")).toTypedArray()
    }
}