package com.example.s8_rodrigo.modelos

open class Persona(
    val nombres: String,
    val apellidos: String,
    val dni: String,
    val correo: String,
    val telefono: String
) {
    open fun obtenerResumen(): String {
        return "$nombres $apellidos - DNI: $dni"
    }
}
