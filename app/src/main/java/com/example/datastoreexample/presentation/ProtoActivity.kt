package com.example.datastoreexample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.datastoreexample.R
import com.example.datastoreexample.databinding.ActivityProtoBinding
import com.example.datastoreexample.domain.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class ProtoActivity: AppCompatActivity() {
    private var _binding: ActivityProtoBinding? = null
    private val binding: ActivityProtoBinding get() = _binding!!

    private val personRepository: PersonRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_proto)

        initView()
    }

    private fun initView() {
        binding.run {
            btnAge.setOnClickListener {
                updateAge()
            }

            btnName.setOnClickListener {
                updateName()

            }

            btnShow.setOnClickListener {
                showPerson()
            }
        }
    }

    private fun getAge(): Int =
        binding.etAge.text.toString().toInt()

    private fun getName(): String =
        binding.etName.text.toString()

    private fun getPersonString(age: Int, name: String): String =
        "Person\nname: $name\nage: $age"

    private fun updateAge() {
        lifecycleScope.launch(Dispatchers.Main) {
            personRepository.updateAgeProto(getAge())
        }
    }

    private fun updateName() {
        lifecycleScope.launch(Dispatchers.Main) {
            personRepository.updateNameProto(getName())
        }
    }

    private fun showPerson() {
        lifecycleScope.launch(Dispatchers.Main) {
            val age = personRepository.readAgeProto().first()
            val name = personRepository.readNameProto().first()

            binding.tvPerson.text = getPersonString(age, name)

            withContext(Dispatchers.IO) {
                // todo something Work Asynchronous
            }
        }
    }
}