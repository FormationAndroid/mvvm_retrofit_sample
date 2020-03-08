package com.example.appmvvm.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.appmvvm.model.Country

interface CountriesRepository {
    fun getCountries(): MutableLiveData<List<Country>>
    fun callCountriesAPI()
}