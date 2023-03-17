package com.example.tipcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRes: Button = findViewById(R.id.buttonRes)
        val totalAmount: EditText = findViewById(R.id.totalAmount)
        val result: TextView = findViewById(R.id.result)
        var flag: Double = 0.0

        val spinner: Spinner = findViewById(R.id.spinner)
        val options = arrayOf("5%", "10%", "15%", "20%")
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                flag = options[position].replace("%", "").toDouble() / 100
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        buttonRes.setOnClickListener {
            val total: Double? = totalAmount.text.toString().toDoubleOrNull()
            val tip: Double = multiply(total,flag)
            val totalWithTip = add(total,tip)

            if (total != null) {
                val tip = total * flag
                val resultText = "Tip: $tip Total: $totalWithTip"
                result.text = resultText
            } else {
                result.text = "Please enter a valid number"
            }
        }
    }
}

public fun add(a: Double?, b: Double): Double {
    return b + a!!
}

public fun multiply(a: Double?, b: Double): Double {
        return b * a!!
}