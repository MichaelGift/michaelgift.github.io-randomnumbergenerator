package com.myth.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val shareLuckyNumberButton  = findViewById<Button>(R.id.BtnShareMyLuck)
        val luckyTextOutput = findViewById<TextView>(R.id.TxtLuckyNumberOutput)

        val userName = receiveUsername()
        val randomLuckyNumber = generateRandomNumber()

        luckyTextOutput.text = "$randomLuckyNumber"

        shareLuckyNumberButton.setOnClickListener{
            shareData(userName, randomLuckyNumber)
        }

    }


    private fun receiveUsername(): String {
        val bundle: Bundle? = intent.extras

        return bundle?.get("name").toString()
    }


    private fun generateRandomNumber(): Int {

        return Random.nextInt(200)
    }

    private fun shareData(userName:String, num : Int){
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "$userName is lucky Today")
        shareIntent.putExtra(Intent.EXTRA_TEXT,"My lucky number is $num")

        startActivity(shareIntent)
    }
}