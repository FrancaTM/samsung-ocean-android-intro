package com.tulio.ocean_android_intro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        const val ENTERED_NAME = "ENTERED_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvOutput = findViewById<TextView>(R.id.tvOutput)
        val etName = findViewById<EditText>(R.id.etName)
        val btSend = findViewById<Button>(R.id.btSend)
        val btOpenResult = findViewById<Button>(R.id.btOpenResult)
        val btReceiveResult = findViewById<Button>(R.id.btReceiveResult)

        btSend.setOnClickListener {""
            if (etName.text.isNotBlank()) {
                tvOutput.text = getString(R.string.hello_name, etName.text.toString())
            } else {
                etName.error = getString(R.string.insert_your_name)
            }
        }

        btOpenResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(ENTERED_NAME, etName.text.toString())
            startActivity(intent)
        }

        btReceiveResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val requestCode = 1

            startActivityForResult(intent, requestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            val result = data.getStringExtra("RESULT")

            val tvResult =  findViewById<TextView>(R.id.tvOutput)
            tvResult.text = "Resultado recebido: $result"
        }
    }
}