package com.example.appmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appmvvm.R
import com.example.appmvvm.model.repository.models.Country
import com.example.appmvvm.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {

    private var countryViewModel:CountryViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //VIEW
        setupBindings(savedInstanceState)
    }

    private fun setupBindings(savedInstanceState: Bundle?){
        val activityMainBinding: com.example.appmvvm.databinding.ActivityMainBinding
        = DataBindingUtil.setContentView(this,R.layout.activity_main)
        countryViewModel= ViewModelProvider(this).get(CountryViewModel::class.java)

        activityMainBinding.model = countryViewModel
        setupListUpdate()
    }

    private fun setupListUpdate(){
        //Call countries
        countryViewModel?.callCountries()
        //getCountries
        countryViewModel?.getCountries()?.observe(this, Observer { countries:List<Country> ->
            CountryViewModel.mainActivity = this
            countryViewModel?.setCountriesInRecyclerAdapter(countries)
        })
    }
}
