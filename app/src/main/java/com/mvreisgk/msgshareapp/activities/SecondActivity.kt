package com.mvreisgk.msgshareapp.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mvreisgk.msgshareapp.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val message = bundle!!.getString("user_message")

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

        val txvUserMessage: TextView = findViewById<TextView>(R.id.txvUserMessage)
        txvUserMessage.text = message
    }

}