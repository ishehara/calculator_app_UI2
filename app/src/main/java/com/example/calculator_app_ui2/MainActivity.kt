package com.example.calculator_app_ui2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator_app_ui2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // this method is use for replacement of android-kotlin-extentions


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()



    }
}