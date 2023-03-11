package com.savchuk.andrew.numberfactsapp.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.savchuk.andrew.numberfactsapp.R
import com.savchuk.andrew.numberfactsapp.databinding.ActivityMainBinding
import com.savchuk.andrew.numberfactsapp.screens.base.NumberFactFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, NumberFactFragment())
                .commit()
        }
    }

}