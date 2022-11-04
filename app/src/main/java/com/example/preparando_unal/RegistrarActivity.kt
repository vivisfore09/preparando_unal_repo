package com.example.preparando_unal

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.preparando_unal.databinding.ActivityRegistrarBinding

class RegistrarActivity :  AppCompatActivity() {

    lateinit var binding: ActivityRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.guardar.setOnClickListener{guardarUsuario()}

    }

    fun guardarUsuario(){

        val correo: String = binding.correo.text.toString()
        val nombre: String = binding.nombres.text.toString()
        val apellido: String = binding.apellidos.text.toString()
        val tel: String = binding.telefono.text.toString()
        val direccion: String = binding.direccion.text.toString()
        val password: String = binding.contraseA.text.toString()
        val genero: Int= binding.genero.id
        var pref=getSharedPreferences(correo,Context.MODE_PRIVATE)
        var edit=pref.edit()
        edit.putString("email",correo)
        edit.putString("nombre",nombre)
        edit.putString("apellido",apellido)
        edit.putString("telefono",tel)
        edit.putString("direccion",direccion)
        edit.putString("password",password)
        if(genero==0){
            edit.putString("genero","Mujer")
        }else{
            edit.putString("genero","Hombre")
        }
        edit.commit()
        Toast.makeText(this,"Usuario registrado exitosamente.", Toast.LENGTH_LONG).show()
    }
}