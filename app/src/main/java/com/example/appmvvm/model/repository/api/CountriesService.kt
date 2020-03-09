package com.example.appmvvm.model.repository.api

import com.example.appmvvm.model.repository.models.Country
import retrofit2.Call
import retrofit2.http.GET

interface CountriesService {
    @GET("all")
    fun listCountries(): Call<List<Country>>
}