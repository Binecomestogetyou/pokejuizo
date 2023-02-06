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
}