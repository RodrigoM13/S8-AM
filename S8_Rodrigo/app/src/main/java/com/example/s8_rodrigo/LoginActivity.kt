package com.example.s8_rodrigo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.s8_rodrigo.datos.Repositorio
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class LoginActivity : AppCompatActivity() {

    private var selectedRole: String? = null

    private val profesores = mapOf(
        "12345678" to "123456",
        "87654321" to "654321"
    )

    private val alumnos = mapOf(
        "202114043" to "password",
        "202114032" to "pass"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val roleToggleGroup = findViewById<MaterialButtonToggleGroup>(R.id.roleToggleGroup)
        val btnProfesor = findViewById<MaterialButton>(R.id.btnProfesor)
        val btnAlumno = findViewById<MaterialButton>(R.id.btnAlumno)
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        roleToggleGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                selectedRole = when (checkedId) {
                    R.id.btnProfesor -> "Profesor"
                    R.id.btnAlumno -> "Alumno"
                    else -> null
                }
            }
        }

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (selectedRole == null || username.isEmpty() || password.isEmpty()) {
                mostrarError("Completa todos los campos y selecciona un rol")
            } else {
                when (selectedRole) {
                    "Profesor" -> {
                        val accesoPredefinido = profesores[username] == password
                        val accesoRegistrado = Repositorio.listaProfesores.any {
                            it.dni == username && it.dni == password
                        }
                        if (accesoPredefinido || accesoRegistrado) {
                            irAlMain("Profesor")
                        } else {
                            mostrarError("DNI o contraseña incorrectos")
                        }
                    }

                    "Alumno" -> {
                        val accesoPredefinido = alumnos[username] == password
                        val accesoRegistrado = Repositorio.listaAlumnos.any {
                            it.codigo == username && it.dni == password
                        }
                        if (accesoPredefinido || accesoRegistrado) {
                            irAlMain("Alumno")
                        } else {
                            mostrarError("Código o DNI incorrectos")
                        }
                    }
                }
            }
        }
    }

    private fun irAlMain(rol: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("ROL", rol)
        startActivity(intent)
        finish()
    }

    private fun mostrarError(mensaje: String) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Error de autenticación")
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar", null)
        builder.show()
    }
}
