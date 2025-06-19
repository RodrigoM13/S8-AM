package com.example.s8_rodrigo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.s8_rodrigo.datos.Repositorio

class ListaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        val listView = view.findViewById<ListView>(R.id.listViewPersonas)

        val alumnos = Repositorio.listaAlumnos.map { it.obtenerResumen() }
        val profesores = Repositorio.listaProfesores.map { it.obtenerResumen() }

        val listaFinal = mutableListOf<String>()

        if (alumnos.isNotEmpty()) {
            listaFinal.add("=== Alumnos ===")
            listaFinal.addAll(alumnos)
        }

        if (profesores.isNotEmpty()) {
            listaFinal.add("=== Profesores ===")
            listaFinal.addAll(profesores)
        }

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            listaFinal
        )
        listView.adapter = adapter

        return view
    }
}
