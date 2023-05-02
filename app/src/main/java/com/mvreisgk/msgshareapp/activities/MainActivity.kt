package com.mvreisgk.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mvreisgk.msgshareapp.R
import com.mvreisgk.msgshareapp.showToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUserMessage: EditText = findViewById<EditText>(R.id.etUserMessage);

        val btnShowToast: Button = findViewById<Button>(R.id.btnShowToast);
        btnShowToast.setOnClickListener {
            // Code
            Log.i("MainActivity", "Button was clicked!")
            showToast("Button was clicked!", Toast.LENGTH_LONG)
        }

        val btnSendMsgToNextActivity: Button = findViewById<Button>(R.id.btnSendMsgToNextActivity);
        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        val btnShareToOtherApps: Button = findViewById<Button>(R.id.btnShareToOtherApps);
        btnShareToOtherApps.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to:"))
        }

        val btnRecyclerViewDemo: Button = findViewById<Button>(R.id.btnRecyclerViewDemo)
        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}