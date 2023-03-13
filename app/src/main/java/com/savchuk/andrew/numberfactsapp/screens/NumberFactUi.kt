package com.savchuk.andrew.numberfactsapp.screens

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NumberFactUi(
    val number: String,
    val fact: String
) : Parcelable