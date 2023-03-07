package com.savchuk.andrew.numberfactsapp.screens.base.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.savchuk.andrew.numberfactsapp.databinding.NumberFactItemBinding
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi

class NumberFactAdapter : ListAdapter<NumberFactUi, NumberFactViewHolder>(NumberDiffUtils()) {

    private var listener: OnNumberClickListener? = null

    interface OnNumberClickListener {
        fun onNumberClick(number: NumberFactUi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberFactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NumberFactItemBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener {
            val fact = it.tag as NumberFactUi
            listener?.onNumberClick(fact)
        }
        return NumberFactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberFactViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setOnClickListener(listener: OnNumberClickListener) {
        this.listener = listener
    }
}