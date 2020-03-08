package com.example.appmvvm.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.appmvvm.model.repository.CountriesRepository
import com.example.appmvvm.model.repository.impl.CountriesRepositoryImpl

class CountryObservable :BaseObservable(){

    private var countryRepository:CountriesRepository=CountriesRepositoryImpl()

    //Repository
    fun callCountries() = countryRepository.callCountriesAPI()

    //ViewModel
    fun getCountries(): MutableLiveData<List<Country>> = countryRepository.getCountries()
}