package com.example.appmvvm.model.repository.api

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface CountriesService {
    // TODO : encapsuler le resultat dans un objet plutôt que dans un JsonArray
    @GET("all")
    fun listCountries(): Call<JsonArray>
}