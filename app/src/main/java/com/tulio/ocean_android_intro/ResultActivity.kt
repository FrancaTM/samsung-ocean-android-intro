package com.tulio.ocean_android_intro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.tulio.ocean_android_intro.MainActivity.Companion.ENTERED_NAME

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val enteredName = intent.getStringExtra(ENTERED_NAME)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = enteredName

        val btSendResult = findViewById<Button>(R.id.btSendResult)
        btSendResult.setOnClickListener {
            val intent = Intent()
            intent.putExtra("RESULT", "Botão enviar resultado clicado!")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}