package com.savchuk.andrew.numberfactsapp.screens.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.savchuk.andrew.numberfactsapp.navigation.Event
import com.savchuk.andrew.numberfactsapp.navigation.NavigatorCommand

open class BaseViewModel : ViewModel() {

    private val _navigation = MutableLiveData<Event<NavigatorCommand>>()
    val navigation: LiveData<Event<NavigatorCommand>> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = Event(NavigatorCommand.ToDirection(navDirections))
    }

    fun navigateBack() {
        _navigation.value = Event(NavigatorCommand.ToBack)
    }

    suspend fun handleUIResult(block: suspend () -> Unit) {
        try {
            block()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}