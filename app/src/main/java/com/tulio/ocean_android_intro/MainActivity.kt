package com.tulio.ocean_android_intro

import android.content.Intent
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
        val etName = findViewById<EditText>(R.id.etName)
        val btSend = findViewById<Button>(R.id.btSend)
        val btOpenResult = findViewById<Button>(R.id.btOpenResult)

        btSend.setOnClickListener {""
            if (etName.text.isNotBlank()) {
                tvOutput.text = "Olá, ${etName.text}!"
            } else {
                etName.error = "Digite um nome..."
            }
        }

        btOpenResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("ENTERED_NAME", etName.text.toString())
            startActivity(intent)
        }
    }
}