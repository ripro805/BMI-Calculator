package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener {
            calculteBMI()
        }
    }
    private fun calculteBMI(){
        val weight=binding.weightEdit.text.toString().toFloatOrNull()
        val height=binding.heightEdit.text.toString().toFloatOrNull()

        if(weight!=null && height!=null){
            val bmi=weight/(height/100).pow(2)
            val bmiResult= String.format("%.2f",bmi)

            val bmiCategory= when{
                bmi<18.5->"UnderWeight"
                bmi<25->"NormalWeight"
                bmi<30->"OverWeight"
                else ->"Obese"
            }
            binding.resultText.text="BMI: $bmiResult\nCategory: $bmiCategory"

        }else{
            binding.resultText.text="Invalid Input"
        }
    }
}
