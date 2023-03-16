package com.savchuk.andrew.numberfactsapp.screens.main

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import com.google.android.material.textfield.TextInputLayout
import com.savchuk.andrew.numberfactsapp.R
import com.savchuk.andrew.numberfactsapp.databinding.FragmentNumberFactBinding
import com.savchuk.andrew.numberfactsapp.screens.NumberFactUi
import com.savchuk.andrew.numberfactsapp.screens.UiState
import com.savchuk.andrew.numberfactsapp.screens.base.BaseFragment
import com.savchuk.andrew.numberfactsapp.screens.main.adapters.NumberFactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberFactFragment : BaseFragment(R.layout.fragment_number_fact) {

    override val viewModel: NumberFactViewModel by viewModels()

    private lateinit var numberFactAdapter: NumberFactAdapter

    private lateinit var binding: FragmentNumberFactBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNumberFactBinding.bind(view)
        numberFactAdapter = NumberFactAdapter()
        numberFactAdapter.setOnClickListener(object : NumberFactAdapter.OnNumberClickListener {
            override fun onNumberClick(number: NumberFactUi) {
                viewModel.onNumberFactClicked(number)
            }
        })

        binding.factsRecyclerView.adapter = numberFactAdapter

        viewModel.listLiveData.observe(viewLifecycleOwner) {
            numberFactAdapter.submitList(it)
        }

        viewModel.factLiveData.observe(viewLifecycleOwner) {
            binding.numberFactTextView.text = "${it.number} ${it.fact}"
        }

        binding.getButton.setOnClickListener {
            viewModel.getNumberFact(binding.numberEditText.text.toString())
            binding.numberEditText.text?.clear()
        }

        binding.getRandomFactButton.setOnClickListener {
            viewModel.getRandomFact()
        }

        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            binding.progressHorizontal.visibility =
                if (state.isProgress) View.VISIBLE else View.GONE

            fillError(binding.numberTextLayout, state.errorMessageRes)
        }
    }

    private fun fillError(input: TextInputLayout, @StringRes stringRes: Int) {
        if (stringRes == UiState.NO_ERROR_MESSAGE) {
            input.error = null
            input.isErrorEnabled = false
        } else {
            input.error = getString(stringRes)
            input.isErrorEnabled = true
        }
    }
}