package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun healtyMessage(bmi: Double): Any? {
            if(bmi<18.5)
                return "Underweight"
            if(bmi<25)
                return "Healty"
            if(bmi<30)
                return "Overweight"

            return "obese"
        }

        fun calculateBMI(){
            val height=binding.heightP.value
            val  Dobuleheight=height.toDouble()/100

            val weight=binding.WeightP.value
            val bmi=weight.toDouble()/(Dobuleheight * Dobuleheight)
            binding.Result.text= String.format("Your BMI is: %2f", bmi)
            binding.HealtyR.text= String.format("Consider: %s", healtyMessage(bmi))

        }

        binding.WeightP.minValue=30
        binding.WeightP.maxValue=150

        binding.heightP.minValue=100
        binding.heightP.maxValue=230
        binding.WeightP.setOnValueChangedListener{_,_,_ ->
            calculateBMI()}






    }



}