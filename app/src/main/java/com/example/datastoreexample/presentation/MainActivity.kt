package com.example.datastoreexample.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.datastoreexample.R
import com.example.datastoreexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
    }

    private fun initView() {
        binding.run {
            btnPreferences.setOnClickListener {
                val intent = Intent(this@MainActivity, PreferencesActivity::class.java)
                startActivity(intent)
            }

            btnProto.setOnClickListener {
                val intent = Intent(this@MainActivity, ProtoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}