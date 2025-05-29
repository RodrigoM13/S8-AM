package com.example.s4_rodrigo

data class Pregunta(
    val texto: String,
    val opciones: List<String>,
    val respuestasCorrectas: List<Int>
)
