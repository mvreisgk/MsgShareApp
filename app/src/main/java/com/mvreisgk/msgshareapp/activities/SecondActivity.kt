package com.mvreisgk.msgshareapp.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mvreisgk.msgshareapp.Constants
import com.mvreisgk.msgshareapp.R
import com.mvreisgk.msgshareapp.showToast

class SecondActivity : AppCompatActivity() {

    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras

        bundle?.let{
            val message = bundle.getString(Constants.USER_MSG_KEY)
            showToast(message!!)
            val txvUserMessage: TextView = findViewById<TextView>(R.id.txvUserMessage)
            txvUserMessage.text = message
        }
    }

}