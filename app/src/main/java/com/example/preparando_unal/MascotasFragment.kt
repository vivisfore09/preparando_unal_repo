package com.example.preparando_unal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.preparando_unal.databinding.FragmentMascotasBinding
import com.example.preparando_unal.databinding.FragmentPaseadoresBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MascotasFragment : Fragment() {

    private var _binding: FragmentMascotasBinding? = null
    private val binding get() = _binding!!
    private  var fab: FloatingActionButton? =null
    private var pref: SharedPreferences? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMascotasBinding.inflate(inflater)
        var view: ConstraintLayout =binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var intent = Intent(context,RegistrarMascota::class.java)

        if(arguments != null){
            val email= requireArguments().getString("email")
            //Toast.makeText(context,"$email", Toast.LENGTH_LONG).show()
            intent.putExtra("email",email)
            pref = this.activity?.getSharedPreferences("usuario",0)
            validar()
        }

        fab = binding.agregar
        fab!!.setOnClickListener(
            View.OnClickListener {

                startActivity(intent)
            }
        )

    }

    fun validar() {

        var email_bd = pref?.getString("usuario", "")
        var nombre_bd = pref?.getString("nombre_mascota", "")
        var tipo_bd = pref?.getString("tipo_mascota", "")
        var raza_bd = pref?.getString("raza_mascota", "")
        var color_bd = pref?.getString("sexo_mascota", "")
        var foto_bd = pref?.getString("foto_mascota", "")
        Toast.makeText(context,"Dueño: $email_bd \nMascota: $nombre_bd", Toast.LENGTH_LONG).show()
    }

}