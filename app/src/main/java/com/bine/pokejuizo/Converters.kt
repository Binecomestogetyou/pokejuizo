package com.bine.pokejuizo

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun fromArrayString(arrayS : Array<String>) : String {

        return Json.encodeToString(arrayS)
    }

    @TypeConverter
    fun toArrayString(str : String) : Array<String> {

        return Json.decodeFromString(str)
    }

    @TypeConverter
    fun fromListPairStringString(list: MutableList<Pair<String, String>>): String {

        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toListPairStringString(str : String) : MutableList<Pair<String, String>> {

        return Json.decodeFromString(str)
    }

    @TypeConverter
    fun fromListPairStringInt(list: MutableList<Pair<String, Int>>): String {

        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toListPairStingInt(str : String) : MutableList<Pair<String, Int>> {

        return Json.decodeFromString(str)
    }

    @TypeConverter
    fun fromListString(list: MutableList<String>) : String {

        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toListString(str: String) : MutableList<String> {

        return Json.decodeFromString(str)
    }

    @TypeConverter
    fun fromListPairStringBool(list : List<Pair<String, Boolean>>) : String {

        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toListPairStringBool(str : String) : List<Pair<String, Boolean>> {

        return Json.decodeFromString(str)
    }

    @TypeConverter
    fun fromListPairIntInt(list : List<Pair<Int, Int>>) : String {

        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toListPairIntInt(str : String) : List<Pair<Int, Int>> {

        return Json.decodeFromString(str)
    }

    @TypeConverter
    fun fromListTriStrStrStr(list: List<Triple<String, String, String>>): String {

        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toListTriStrStrStr(str : String) : List<Triple<String, String, String>> {

        return Json.decodeFromString(str)
    }
}