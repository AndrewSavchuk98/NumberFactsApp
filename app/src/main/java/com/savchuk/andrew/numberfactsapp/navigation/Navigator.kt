package com.savchuk.andrew.numberfactsapp.navigation

import androidx.navigation.NavDirections

sealed class NavigatorCommand{
    class ToDirection(val direction: NavDirections): NavigatorCommand()
    object ToBack: NavigatorCommand()
}