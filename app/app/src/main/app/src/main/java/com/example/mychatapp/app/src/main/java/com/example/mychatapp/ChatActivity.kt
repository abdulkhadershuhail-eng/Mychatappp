package com.example.mychatapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {

    private lateinit var chatBox: TextView
    private lateinit var inputBox: EditText
    private lateinit var sendBtn: Button
    private var chatHistory = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val username = intent.getStringExtra("username") ?: "User"

        chatBox = findViewById(R.id.chatBox)
        inputBox = findViewById(R.id.messageInput)
        sendBtn = findViewById(R.id.sendBtn)

        sendBtn.setOnClickListener {
            val msg = inputBox.text.toString().trim()
            if (msg.isNotEmpty()) {
                chatHistory += "\n$username: $msg"
                chatBox.text = chatHistory
                inputBox.text.clear()
            }
        }
    }
}
