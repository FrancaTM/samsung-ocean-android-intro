package com.tulio.ocean_android_intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val enteredName = intent.getStringExtra("ENTERED_NAME")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = enteredName
    }
}