package com.example.appmvvm.model.repository.impl

import androidx.lifecycle.MutableLiveData
import com.example.appmvvm.model.repository.CountriesRepository
import com.example.appmvvm.model.repository.api.ReferenceCountryService
import retrofit2.Call
import retrofit2.Response
import com.example.appmvvm.model.repository.models.Country
import retrofit2.Callback

class CountriesRepositoryImpl : CountriesRepository {

    private var countries = MutableLiveData<List<Country>>()

    override fun getCountries() = countries

    override fun callCountriesAPI() {
        val countriesList: ArrayList<Country>? = ArrayList()
        val apiAdapter = ReferenceCountryService()
        val apiService = apiAdapter.getClientService()
        val call = apiService.listCountries()

        call.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {

                response.body()?.forEach { country ->
                    countriesList?.add(country)
                }


                countries.value = countriesList

            }

        })
    }

}