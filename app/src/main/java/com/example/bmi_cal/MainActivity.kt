package com.example.bmi_cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val age: EditText = findViewById(R.id.age_id)
        val height: EditText = findViewById(R.id.height_id)
        val weight: EditText = findViewById(R.id.weight_id)
        val ans: TextView = findViewById(R.id.cal_bmi)
        val cal_btn: Button = findViewById(R.id.cal_btn)
        val about : TextView = findViewById(R.id.about)

            cal_btn.setOnClickListener {

                var weight1 = 0.0
                var age1 = 0
                var height1 = 0.0

                if (age.text.toString().isEmpty() && height.text.toString().isEmpty() && weight.text.toString().isEmpty())
                {
                    Toast.makeText(this, "please fill all details ", Toast.LENGTH_SHORT).show()
                }
                if (age.text.toString().isNotEmpty()) {
                    age1 = age.text.toString().toInt()
                    if (height.text.toString().isNotEmpty()) {
                        height1 = height.text.toString().toDouble()
                        if (weight.text.toString().isNotEmpty()) {
                            weight1 = weight.text.toString().toDouble()
                            var h: Double = height1 / 100
                            h *= h

                            var bmi: Double =  weight1 / h
                            ans.setText("Your BMI: " + (bmi).toDouble())

                            var str: String? = null
                            if (bmi <= 18.5) {

                                str = "You are Underweight "
                            }
                            if (bmi >= 18.5) {
                                if (bmi <= 24.9) {
                                    str = "Your weight is Normal  "
                                }
                            }
                            if (bmi >= 25) {
                                if (bmi <= 29.9) {
                                    str = "You are Overweight  "
                                }
                            }
                            if (bmi >= 30) {
                                str = "You are Obesity "
                            }

                            about.setText(str)
                            cal_btn.setText("Clear")

                        } else {
                            Toast.makeText(this, "please enter weight ", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "please enter height ", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "please enter age ", Toast.LENGTH_SHORT).show()
                }

                if (cal_btn.text.toString() == "Clear")
                {
                    cal_btn.setOnClickListener {

                        age.text.clear()
                        height.text.clear()
                        weight.text.clear()
                        ans.setText("")
                        about.setText("")
                        cal_btn.setText("Calculate")
                    }
                }

           }
    }
}


