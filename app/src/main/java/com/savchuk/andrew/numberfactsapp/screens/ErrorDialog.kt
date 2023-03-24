package com.savchuk.andrew.numberfactsapp.screens

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import com.savchuk.andrew.numberfactsapp.R

class ErrorDialog(
    @StringRes private val message: Int,
    private val listener: ClickListener
) : DialogFragment() {

    interface ClickListener {
        fun onClick()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val view = inflater.inflate(R.layout.dialog_fragment_error_view, null)

            builder.setView(view)

            val textView = view.findViewById<TextView>(R.id.errorTextView)
            view.findViewById<Button>(R.id.tryAgainButton).setOnClickListener {
                listener.onClick()
                dismiss()
            }
            textView.setText(message)
            // Add action buttons


            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}