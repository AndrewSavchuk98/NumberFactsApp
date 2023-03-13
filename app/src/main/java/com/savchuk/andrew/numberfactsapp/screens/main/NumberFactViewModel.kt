package com.savchuk.andrew.numberfactsapp.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.savchuk.andrew.numberfactsapp.domain.Mapper
import com.savchuk.andrew.numberfactsapp.domain.NumberFact
import com.savchuk.andrew.numberfactsapp.domain.NumberFactsRepository
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi
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
        viewModelScope.launch {
            handleUIResult {
                _factLiveData.value = mapper.map(repository.getNumberFact(number))
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
}