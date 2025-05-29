package com.example.clinicas5_rodrigo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(private var doctores: MutableList<Doctor>) :
    RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    inner class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgDoctorProfile: ImageView = itemView.findViewById(R.id.imgDoctorProfile)
        val txtNombre: TextView = itemView.findViewById(R.id.tvDoctorName)
        val txtEspecialidad: TextView = itemView.findViewById(R.id.tvSpecialty)
        val btnVerPerfil: Button = itemView.findViewById(R.id.btnVerPerfil)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctores[position]

        holder.txtNombre.text = doctor.nombre
        holder.txtEspecialidad.text = doctor.especialidad

        val nombreLower = doctor.nombre.trim().lowercase()

        when {
            nombreLower.startsWith("dra.") || nombreLower.startsWith("lic.") ->
                holder.imgDoctorProfile.setImageResource(R.drawable.doctora)
            else ->
                holder.imgDoctorProfile.setImageResource(R.drawable.doctor)
        }

        holder.btnVerPerfil.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DoctorActivity::class.java).apply {
                putExtra("doctorNombre", doctor.nombre)
                putExtra("doctorEspecialidad", doctor.especialidad)
                putExtra("doctorCelular", doctor.celular)
                putExtra("doctorHorario", doctor.horario)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = doctores.size

    fun actualizarLista(nuevaLista: List<Doctor>) {
        doctores.clear()
        doctores.addAll(nuevaLista)
        notifyDataSetChanged()
    }
}
