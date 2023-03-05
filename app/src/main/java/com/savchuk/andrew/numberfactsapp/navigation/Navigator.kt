package com.savchuk.andrew.numberfactsapp.navigation

import androidx.fragment.app.Fragment
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi

fun Fragment.navigator() = requireActivity() as Navigator

interface Navigator {

    fun  goFactDetail(fact: NumberFactUi)

    fun goBack()
}