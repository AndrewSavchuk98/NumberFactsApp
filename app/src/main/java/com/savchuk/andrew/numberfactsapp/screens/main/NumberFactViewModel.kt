package com.savchuk.andrew.numberfactsapp.screens.main

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.savchuk.andrew.numberfactsapp.R
import com.savchuk.andrew.numberfactsapp.domain.Mapper
import com.savchuk.andrew.numberfactsapp.domain.NumberFact
import com.savchuk.andrew.numberfactsapp.domain.NumberFactsRepository
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi
import com.savchuk.andrew.numberfactsapp.screens.UiState
import com.savchuk.andrew.numberfactsapp.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberFactViewModel @Inject constructor(
    private val repository: NumberFactsRepository,
    private val mapper: Mapper<NumberFact, NumberFactUi>
) : BaseViewModel() {

    private val _factLiveData = MutableLiveData<NumberFactUi>()
    val factLiveData: LiveData<NumberFactUi> = _factLiveData

    private val _listLiveData = MutableLiveData<List<NumberFactUi>>()
    val listLiveData: LiveData<List<NumberFactUi>> = _listLiveData

    private val _stateLiveData = MutableLiveData<UiState>()
    val stateLiveData: LiveData<UiState> = _stateLiveData

    init {
        viewModelScope.launch {
            repository.readNumbersFact().collect { list ->
                _listLiveData.value = list.map { NumberFactUi(it.number, it.fact) }
            }
        }
    }

    fun onNumberFactClicked(number: NumberFactUi) {
        navigate(
            NumberFactFragmentDirections.actionNumberFactFragmentToNumberDetailFragment(
                number
            )
        )
    }

    fun getNumberFact(number: String) {
        when {
            number.isBlank() -> {
                _stateLiveData.value = UiState(errorMessageRes = R.string.input_empty_message)
            }
            !number.isDigitsOnly() -> {
                _stateLiveData.value = UiState(errorMessageRes = R.string.input_error_message)
            }
            else -> {
                showProgress()
                viewModelScope.launch {
                    handleUIResult {
                        _factLiveData.value = mapper.map(repository.getNumberFact(number))
                        hideProgress()
                    }
                }
            }
        }
    }

    fun getRandomFact() {
        viewModelScope.launch {
            handleUIResult {
                _factLiveData.value = mapper.map(repository.getRandomFact())
            }
        }
    }

    private fun showProgress() {
        _stateLiveData.value = UiState(isProgress = true)
    }

    private fun hideProgress() {
        _stateLiveData.value = _stateLiveData.value?.copy(isProgress = false)
    }
}