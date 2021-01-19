package com.tulio.ocean_android_intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvOutput = findViewById<TextView>(R.id.tvOutput)
        val btSend = findViewById<Button>(R.id.btSend)
        val etName = findViewById<EditText>(R.id.etName)

        btSend.setOnClickListener {""
            if (etName.text.isNotBlank()) {
                tvOutput.text = "Olá, ${etName.text}!"
            } else {
                etName.error = "Digite um nome..."
            }
        }
    }
}