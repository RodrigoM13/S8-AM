package com.example.register

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.register.databinding.ActivityRegisterBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val codigo = binding.etCode.text.toString()
            val nombres = binding.etFirstname.text.toString()
            val apellidos = binding.etLastname.text.toString()
            val correo = binding.etEmail.text.toString()

            if (codigo.isNotBlank() && nombres.isNotBlank() && apellidos.isNotBlank() && correo.isNotBlank()) {
                val nuevoUsuario = Usuario(codigo, nombres, apellidos, correo)

                UsuarioRepository.usuarios.add(nuevoUsuario)

                limpiarCampos()

                val intent = Intent(this, ReportActivity::class.java)
                startActivity(intent)
            }
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_register -> true
                R.id.nav_table -> {
                    startActivity(Intent(this, ReportActivity::class.java))
                    true
                }
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun limpiarCampos() {
        binding.etCode.text?.clear()
        binding.etFirstname.text?.clear()
        binding.etLastname.text?.clear()
        binding.etEmail.text?.clear()
    }
}

