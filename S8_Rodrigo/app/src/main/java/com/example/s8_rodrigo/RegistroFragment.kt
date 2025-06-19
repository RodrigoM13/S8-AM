package com.example.s8_rodrigo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.s8_rodrigo.datos.Repositorio
import com.example.s8_rodrigo.modelos.Alumno
import com.example.s8_rodrigo.modelos.Profesor

class RegistroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registro, container, false)

        val rol = arguments?.getString("ROL") ?: "Alumno"

        val codigo = view.findViewById<EditText>(R.id.editCodigo)
        val nombres = view.findViewById<EditText>(R.id.editNombres)
        val apellidos = view.findViewById<EditText>(R.id.editApellidos)
        val dni = view.findViewById<EditText>(R.id.editDni)
        val telefono = view.findViewById<EditText>(R.id.editTelefono)
        val correo = view.findViewById<EditText>(R.id.editCorreo)
        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)

        if (rol == "Profesor") {
            codigo.visibility = View.GONE
        }

        btnGuardar.setOnClickListener {
            val nombresText = nombres.text.toString()
            val apellidosText = apellidos.text.toString()
            val dniText = dni.text.toString()
            val telefonoText = telefono.text.toString()
            val correoText = correo.text.toString()
            val codigoText = codigo.text.toString()

            if (rol == "Profesor") {
                val profesor = Profesor(nombresText, apellidosText, dniText, correoText, telefonoText)
                Repositorio.listaProfesores.add(profesor)
            } else {
                val alumno = Alumno(nombresText, apellidosText, dniText, codigoText, correoText, telefonoText)
                Repositorio.listaAlumnos.add(alumno)
            }

            val mensaje = if (rol == "Profesor") {
                "Profesor registrado correctamente"
            } else {
                "Alumno registrado correctamente"
            }

            Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()

            nombres.setText("")
            apellidos.setText("")
            dni.setText("")
            telefono.setText("")
            correo.setText("")
            if (rol != "Profesor") codigo.setText("")
        }

        return view
    }
}
