package com.example.mychatapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val codeInput = findViewById<EditText>(R.id.inviteCodeInput)
        val nameInput = findViewById<EditText>(R.id.usernameInput)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {
            val code = codeInput.text.toString().trim()
            val username = nameInput.text.toString().trim()

            if (code == "SECRET123" && username.isNotEmpty()) {
                val intent = Intent(this, ChatActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid code or name!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
