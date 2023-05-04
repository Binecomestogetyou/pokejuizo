package com.bine.pokejuizo

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromArrayString(arrayS : Array<String>) : String {

        return arrayS.joinToString(", ")
    }

    @TypeConverter
    fun toArrayString(str : String) : Array<String> {

        return str.split(Regex(", ")).toTypedArray()
    }

    @TypeConverter
    fun fromListPairStringString(list: MutableList<Pair<String, String>>): String {

        return list.map { element ->
            element.first + "::" + element.second }
            .joinToString(", ")
    }

    @TypeConverter
    fun toListPairStringString(str : String) : MutableList<Pair<String, String>> {

        return str.split(", ").map { element ->
                Pair(
                    element.split("::")[0],
                    element.split("::")[1]
                )
            } as MutableList<Pair<String, String>>
    }

    @TypeConverter
    fun fromListPairStringInt(list: MutableList<Pair<String, Int>>): String {

        return list.map { element ->
            element.first + "::" + element.second }
            .joinToString(", ")
    }

    @TypeConverter
    fun toListPairStingInt(str : String) : MutableList<Pair<String, Int>> {

        return str.split(", ").map { element ->
            Pair(
                element.split("::")[0],
                element.split("::")[1].toInt()
            )
        } as MutableList<Pair<String, Int>>
    }
}