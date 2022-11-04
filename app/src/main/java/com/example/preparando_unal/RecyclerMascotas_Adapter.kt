package com.example.preparando_unal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerMascotas_Adapter(var listaPaseadores:MutableList<Paseador>):
    RecyclerView.Adapter<RecyclerMascotas_Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var nombres:TextView
        var ciudad:TextView
        var telefono:TextView
        lateinit var img: ImageView
    init {
        nombres = itemView.findViewById(R.id.nombresP)
        ciudad = itemView.findViewById(R.id.ciudadP)
        telefono = itemView.findViewById(R.id.telefonoP)
        img = itemView.findViewById(R.id.foto)
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.carta_paseador,parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var paseador = listaPaseadores[position]
        holder.nombres.text= paseador.nombre
        holder.ciudad.text= paseador.ciudad
        holder.telefono.text= paseador.telefono
        holder.img.setImageResource(paseador.img)
    }

    override fun getItemCount(): Int {
        return listaPaseadores.size
    };


}