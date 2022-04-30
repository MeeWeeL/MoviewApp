package com.meeweel.movieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meeweel.movieapp.R
import com.meeweel.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainScreenFragment()).commitNow()
    }
}