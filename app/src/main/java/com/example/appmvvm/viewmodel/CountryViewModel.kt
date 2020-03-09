package com.example.appmvvm.viewmodel

import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmadrosid.svgloader.SvgLoader
import com.example.appmvvm.R
import com.example.appmvvm.model.CountryObservable
import com.example.appmvvm.model.repository.models.Country
import com.example.appmvvm.view.CountryRecyclerAdapter
import com.example.appmvvm.view.DetailCountryActivity
import com.example.appmvvm.view.MainActivity

class CountryViewModel : ViewModel() {

    private var countryObservable: CountryObservable = CountryObservable()
    private var countryRecyclerAdapter: CountryRecyclerAdapter? = null

    fun callCountries() {
        countryObservable.callCountries()
    }

    fun getCountries(): MutableLiveData<List<Country>> {
        return countryObservable.getCountries()
    }

    fun setCountriesInRecyclerAdapter(countries: List<Country>) {
        countryRecyclerAdapter?.setCountriesList(countries)
        countryRecyclerAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCountriesAdapter(): CountryRecyclerAdapter? {
        countryRecyclerAdapter = CountryRecyclerAdapter(this)
        return countryRecyclerAdapter
    }

    fun getCountryAt(position: Int): Country? {
        val countries: List<Country>? = countryObservable.getCountries().value
        return countries?.get(position)
    }

    companion object {
        var mainActivity: MainActivity? = null

        @JvmStatic
        @BindingAdapter("svgSrc")
        fun setFlag(imageView: ImageView, uriFlag: String) {
            SvgLoader.pluck()
                .with(mainActivity)
                .setPlaceHolder(R.drawable.loading_spinner, R.drawable.loading_spinner)
                .load(uriFlag, imageView)
        }

        @JvmStatic
        @BindingAdapter("showDetails")
        fun openDetailsActivity(view: View, country: Country) {
            view.setOnClickListener {
                val showCountryIntent = Intent(view.context, DetailCountryActivity::class.java)
                showCountryIntent.putExtra("country", country)
                view.context.startActivity(showCountryIntent)
            }

        }
    }


}