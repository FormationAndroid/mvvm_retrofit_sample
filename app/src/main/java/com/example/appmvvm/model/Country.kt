package com.example.appmvvm.model


import com.google.gson.JsonObject
import java.io.Serializable
import java.lang.Exception

class Country(countryJson: JsonObject?) : Serializable {
    lateinit var name: String
    lateinit var uriFlag: String
    lateinit var capital: String
    lateinit var population: String
    lateinit var region: String
    lateinit var alpha3Code: String
    lateinit var area: String

    init {
        try {
            name = countryJson!!.get(NAME).asString
            uriFlag = countryJson.get(FLAG).asString
            capital = countryJson.get(CAPITAL).asString
            population = countryJson.get(POPULATION).asString
            region = countryJson.get(REGION).asString
            alpha3Code = countryJson.get(ALPHACODE).asString
            area = countryJson.get(AREA).asString


        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {
        private const val NAME = "name"
        private const val FLAG = "flag"
        private const val CAPITAL = "capital"
        private const val POPULATION = "population"
        private const val REGION = "region"
        private const val ALPHACODE = "alpha3Code"
        private const val AREA = "area"
    }
}