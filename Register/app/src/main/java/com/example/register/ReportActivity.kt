package com.example.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.register.databinding.ActivityReportBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ReportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarios = UsuarioRepository.usuarios
        llenarTabla(usuarios)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_register -> {
                    startActivity(Intent(this, RegisterActivity::class.java))
                    true
                }
                R.id.nav_table -> true // Ya estamos en esta pantalla
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun llenarTabla(usuarios: List<Usuario>) {
        val tableBody = binding.tableBody

        tableBody.removeAllViews()

        for (usuario in usuarios) {
            val row = LayoutInflater.from(this).inflate(R.layout.table_row, null)

            val tvCodigo = row.findViewById<TextView>(R.id.tvCodigo)
            val tvNombre = row.findViewById<TextView>(R.id.tvNombre)
            val tvApellido = row.findViewById<TextView>(R.id.tvApellido)
            val tvCorreo = row.findViewById<TextView>(R.id.tvCorreo)

            tvCodigo.text = usuario.codigo
            tvNombre.text = usuario.nombres
            tvApellido.text = usuario.apellidos
            tvCorreo.text = usuario.correo

            tableBody.addView(row)
        }
    }
}
