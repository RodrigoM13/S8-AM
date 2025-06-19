package com.example.s8_rodrigo.modelos

class Profesor(
    nombres: String,
    apellidos: String,
    dni: String,
    correo: String,
    telefono: String
) : Persona(nombres, apellidos, dni, correo, telefono) {
    override fun obtenerResumen(): String {
        return """
            Profesor: $nombres $apellidos
            DNI: $dni
            Correo: $correo
            Teléfono: $telefono
        """.trimIndent()
    }
}
