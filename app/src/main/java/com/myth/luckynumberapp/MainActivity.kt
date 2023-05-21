package com.myth.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishMeLuckButton = findViewById<Button>(R.id.BtnShowLuckyNumber)
        val userNameInput = findViewById<EditText>(R.id.EtxtPersonName)

        wishMeLuckButton.setOnClickListener{
            val name = userNameInput.text

            val goToSecondActivity = Intent(this, LuckyNumberActivity::class.java)

            goToSecondActivity.putExtra("name", name)
            startActivity(goToSecondActivity)
        }
    }
}
