package com.mvreisgk.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUserMessage: EditText = findViewById<EditText>(R.id.etUserMessage);

        val btnShowToast: Button = findViewById<Button>(R.id.btnShowToast);
        btnShowToast.setOnClickListener {
            // Code
            Log.i("MainActivity", "Button was clicked!")
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
        }

        val btnSendMsgToNextActivity: Button = findViewById<Button>(R.id.btnSendMsgToNextActivity);
        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }
    }
}