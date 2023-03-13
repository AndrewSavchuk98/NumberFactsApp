package com.savchuk.andrew.numberfactsapp.screens.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.savchuk.andrew.numberfactsapp.navigation.NavigatorCommand

abstract class BaseFragment(
    @LayoutRes private val layoutId: Int
) : Fragment(layoutId) {

    abstract val viewModel: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigation.observe(viewLifecycleOwner) {
            it.get()?.let { navCommand ->
                when (navCommand) {
                    is NavigatorCommand.ToDirection -> findNavController().navigate(navCommand.direction)
                    is NavigatorCommand.ToBack -> findNavController().navigateUp()
                }
            }
        }
    }
}