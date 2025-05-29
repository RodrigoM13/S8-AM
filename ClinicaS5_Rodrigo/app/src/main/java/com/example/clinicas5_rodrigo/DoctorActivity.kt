package com.example.clinicas5_rodrigo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DoctorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)

        val imgDoctorProfile = findViewById<ImageView>(R.id.imgDoctorProfile)
        val txtDoctorNombre = findViewById<TextView>(R.id.txtDoctorNombre)
        val txtDoctorEspecialidad = findViewById<TextView>(R.id.txtDoctorEspecialidad)
        val txtDoctorCelular = findViewById<TextView>(R.id.txtDoctorCelular)
        val txtDoctorHorario = findViewById<TextView>(R.id.txtDoctorHorario)

        val nombre = intent.getStringExtra("doctorNombre") ?: "Desconocido"
        val especialidad = intent.getStringExtra("doctorEspecialidad") ?: "Especialidad desconocida"
        val celular = intent.getStringExtra("doctorCelular") ?: "No disponible"
        val horario = intent.getStringExtra("doctorHorario") ?: "No disponible"

        txtDoctorNombre.text = nombre
        txtDoctorEspecialidad.text = especialidad
        txtDoctorCelular.text = "Celular: $celular"
        txtDoctorHorario.text = "Horario: $horario"

        val nombreLower = nombre.trim().lowercase()

        when {
            nombreLower.startsWith("dr.") -> imgDoctorProfile.setImageResource(R.drawable.doctor)
            nombreLower.startsWith("dra.") || nombreLower.startsWith("lic.") -> imgDoctorProfile.setImageResource(R.drawable.doctora)
            else -> imgDoctorProfile.setImageResource(R.drawable.doctor)
        }
    }
}
