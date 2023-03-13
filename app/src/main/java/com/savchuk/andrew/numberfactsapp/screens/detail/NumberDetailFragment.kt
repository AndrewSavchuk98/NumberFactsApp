package com.savchuk.andrew.numberfactsapp.screens.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.savchuk.andrew.numberfactsapp.R
import com.savchuk.andrew.numberfactsapp.databinding.FragmentNumberDetailBinding
import com.savchuk.andrew.numberfactsapp.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberDetailFragment : BaseFragment(R.layout.fragment_number_detail) {

    override val viewModel: NumberDetailViewModel by viewModels()

    private lateinit var binding: FragmentNumberDetailBinding

    private val args: NumberDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNumber(args.number)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNumberDetailBinding.bind(view)
        binding.backButton.setOnClickListener {
            viewModel.navigateBack()
        }
        viewModel.numberDetail.observe(viewLifecycleOwner) {
            with(binding) {
                numberTextView.text = it.number
                factTextView.text = it.fact
            }
        }
    }
}