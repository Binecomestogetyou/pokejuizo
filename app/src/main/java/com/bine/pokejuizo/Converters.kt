package com.bine.pokejuizo

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromArrayString(arrayS : Array<String>) : String {

        return arrayS.joinToString(", ")
    }

    @TypeConverter
    fun fromStringIntoArray(str : String) : Array<String> {

        return str.split(Regex(", ")).toTypedArray()
    }

    @TypeConverter
    fun fromListPairString(list: MutableList<Pair<String, String>>): String {

        return list.map { element ->
            element.first + "::" + element.second }
            .joinToString(", ")
    }

    @TypeConverter
    fun fromString(str : String) : MutableList<Pair<String, String>> {

        return str.split(", ").map { element ->
                Pair(
                    element.split("::")[0],
                    element.split("::")[1]
                )
            } as MutableList<Pair<String, String>>
    }
}