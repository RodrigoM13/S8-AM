package com.example.s3rodrigo

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layout = findViewById<ConstraintLayout>(R.id.main)
        val button = findViewById<Button>(R.id.btn_click)

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.anim_fondo)
        val scaleFadeIn = AnimationUtils.loadAnimation(this, R.anim.anim_boton)

        layout.startAnimation(fadeIn)
        button.startAnimation(scaleFadeIn)

        button.setOnClickListener {
            val intent = Intent(this, CartaActivity::class.java)
            startActivity(intent)
        }
    }
}
