package com.example.s4_rodrigo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUserName = findViewById<EditText>(R.id.etNombre)
        val btnLogin = findViewById<Button>(R.id.startButton)

        btnLogin.setOnClickListener {
            val userName = etUserName.text.toString().trim()
            if(userName.isNotEmpty()){
                val prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
                prefs.edit().putString("USER_NAME", userName).apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                etUserName.error = "Por favor ingresa tu nombre"
            }
        }
    }
}
