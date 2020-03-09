package com.example.appmvvm.view

import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

import com.example.appmvvm.BR
import com.example.appmvvm.R

import com.example.appmvvm.model.repository.models.Country
import com.example.appmvvm.viewmodel.CountryViewModel

class CountryRecyclerAdapter(private var countryViewModel: CountryViewModel) :
    RecyclerView.Adapter<CountryRecyclerAdapter.CardCountryHolder>() {

    var countries: List<Country>? = null

    fun setCountriesList(countries: List<Country>) {
        this.countries = countries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCountryHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return CardCountryHolder(binding)
    }

    override fun onBindViewHolder(holder: CardCountryHolder, position: Int) {
        holder.setDataCard(countryViewModel,position)
    }

    class CardCountryHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        private var binding:ViewDataBinding?=null

        init {
            this.binding = binding
        }

        fun setDataCard(countryViewModel: CountryViewModel,position: Int) {
            binding?.setVariable(BR.model,countryViewModel)
            binding?.setVariable(BR.position,position)
            binding?.executePendingBindings()
        }

    }

    override fun getItemViewType(position: Int) = R.layout.item_country

    override fun getItemCount() = countries?.size ?: 0

}