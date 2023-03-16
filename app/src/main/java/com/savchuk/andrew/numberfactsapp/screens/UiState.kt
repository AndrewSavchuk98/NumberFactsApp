package com.savchuk.andrew.numberfactsapp.screens

data class UiState(
    val isProgress: Boolean = false,
    val errorMessageRes: Int = NO_ERROR_MESSAGE
) {
    companion object {
        const val NO_ERROR_MESSAGE = 0
    }
}
