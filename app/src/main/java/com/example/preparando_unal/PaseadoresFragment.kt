package com.example.preparando_unal
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.preparando_unal.databinding.FragmentPaseadoresBinding


class PaseadoresFragment : Fragment() {


    private var _binding: FragmentPaseadoresBinding? = null
    private val binding get() = _binding!!

    private lateinit var recycler: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaseadoresBinding.inflate(inflater)
        var view:FrameLayout=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listaPaseadores:MutableList<Paseador> = mutableListOf()
        listaPaseadores.add(Paseador("Viviana Forero","3125679087","Bogotá",R.drawable.chico))
        listaPaseadores.add(Paseador("Pedro Picapiedra","3125679087","Medellin",R.drawable.mascota))
        listaPaseadores.add(Paseador("Pablo Marmol","3125679087","Cali",R.drawable.info))
        listaPaseadores.add(Paseador("Mateo Forero","3125679087","Bogotá",R.drawable.persona2))
        listaPaseadores.add(Paseador("Valeria Gomez","3125679087","Medellin",R.drawable.telefono))
        listaPaseadores.add(Paseador("Luisa Giraldo","3125679087","Cali",R.drawable.info))

        binding.recyclerPaseador.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter=RecyclerPaseador(listaPaseadores)
        }


    }




}