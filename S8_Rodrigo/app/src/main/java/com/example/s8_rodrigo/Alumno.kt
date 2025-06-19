package com.example.s8_rodrigo.modelos

class Alumno(
    nombres: String,
    apellidos: String,
    dni: String,
    val codigo: String,
    correo: String,
    telefono: String
) : Persona(nombres, apellidos, dni, correo, telefono) {
    override fun obtenerResumen(): String {
        return """
            Alumno: $nombres $apellidos
            Código: $codigo
            Correo: $correo
            Teléfono: $telefono
        """.trimIndent()
    }
}
