package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        val calBtn : Button = findViewById(R.id.calculate_btn)
        calBtn.text = "Calculate"
         */

        binding.calculateBtn.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = "ERROR!"
            return
        }
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercent = when (selectedId) {
            R.id.option_20 -> 0.20
            R.id.option_15 -> 0.15
            else -> 0.10
        }
        var tip = cost * tipPercent
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        binding.tipResult.text = tip.toString()
    }
}