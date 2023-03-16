package com.savchuk.andrew.numberfactsapp.screens.main.adapters

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.savchuk.andrew.numberfactsapp.databinding.NumberFactItemBinding
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi

class NumberFactViewHolder(private val binding: NumberFactItemBinding) :
    ViewHolder(binding.root) {

    fun bind(numberFact: NumberFactUi) {
        binding.numberTextView.text = numberFact.number
        binding.factTextView.text = numberFact.fact
    }
}