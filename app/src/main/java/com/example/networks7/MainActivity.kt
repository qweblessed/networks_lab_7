package com.example.networks7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.networks7.databinding.ActivityMainBinding
import com.example.networks7.model.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = Retrofit.retrofit

        binding.generateButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val ip = binding.ipEditText.text.toString().trim()
                    if (ip.isEmpty()) throw Exception()
                    val response = retrofit.getData(ip)
                    val data = response.body()!!
                    setData(data)
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        binding.errorTextView.visibility = View.VISIBLE
                        binding.informationLayout.visibility = View.GONE
                    }
                }

            }

        }

    }

    private fun setData(data: Data) {
        binding.informationLayout.visibility = View.VISIBLE
        binding.errorTextView.visibility = View.GONE
        binding.timezoneTextView.text = data.timezone
        binding.dateTimeTextView.text = data.datetime
        binding.dayOfYearTextView.text = data.day_of_year.toString()
    }
}