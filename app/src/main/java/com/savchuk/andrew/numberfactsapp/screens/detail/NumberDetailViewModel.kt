package com.savchuk.andrew.numberfactsapp.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi
import com.savchuk.andrew.numberfactsapp.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NumberDetailViewModel @Inject constructor() : BaseViewModel() {

    private val _numberDetail = MutableLiveData<NumberFactUi>()
    val numberDetail: LiveData<NumberFactUi> = _numberDetail

    fun setNumber(numberFactUi: NumberFactUi) {
        _numberDetail.value = numberFactUi
    }
}