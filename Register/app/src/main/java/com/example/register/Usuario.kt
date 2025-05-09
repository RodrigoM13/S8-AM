package com.example.register

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(
    val codigo: String,
    val nombres: String,
    val apellidos: String,
    val correo: String
) : Parcelable
