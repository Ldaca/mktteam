package com.ldaca.app.ready.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ldaca.app.ready.R
import com.ldaca.app.ready.databinding.ActivityDetailBinding
import com.ldaca.app.ready.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}