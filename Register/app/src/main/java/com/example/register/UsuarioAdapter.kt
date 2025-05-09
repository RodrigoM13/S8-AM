package com.example.register

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.register.databinding.ItemUsuarioBinding

class UsuarioAdapter(private var usuarios: List<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    inner class UsuarioViewHolder(val binding: ItemUsuarioBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsuarioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.binding.tvNombre.text = usuario.nombres
        holder.binding.tvApellido.text = usuario.apellidos
        holder.binding.tvCodigo.text = "Código: ${usuario.codigo}"
        holder.binding.tvCorreo.text = "Correo: ${usuario.correo}"
    }

    override fun getItemCount(): Int = usuarios.size

    fun setUsuarios(usuarios: List<Usuario>) {
        this.usuarios = usuarios
        notifyDataSetChanged()
    }
}

