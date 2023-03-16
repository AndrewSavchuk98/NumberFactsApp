package com.savchuk.andrew.numberfactsapp.screens.main.adapters

import androidx.recyclerview.widget.DiffUtil
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi

class NumberDiffUtils : DiffUtil.ItemCallback<NumberFactUi>() {
    override fun areItemsTheSame(oldItem: NumberFactUi, newItem: NumberFactUi): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: NumberFactUi, newItem: NumberFactUi): Boolean {
        return oldItem == newItem
    }
}