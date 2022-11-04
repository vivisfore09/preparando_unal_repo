package com.example.preparando_unal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.preparando_unal.databinding.ActivityHomeBinding
import com.example.preparando_unal.databinding.ActivityRegistrarBinding
class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email=intent.getStringExtra("email")


        var mascotas_F= MascotasFragment()
        var paseadores_F= PaseadoresFragment()
        var paseos_F= PaseosFragment()
        var ideas_F= IdeasFragment()

        val bundle = Bundle()
        bundle.putString("email",email)
        mascotas_F.arguments= bundle


        binding.bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.mascotas ->{ menuInferior(mascotas_F)
                    true
                }
                R.id.paseadores ->{ menuInferior(paseadores_F)
                    true
                }
                R.id.paseos ->{ menuInferior(paseos_F)
                    true
                }
                R.id.ideas ->{ menuInferior(ideas_F)
                    true
                }
                else->false
            }
        }
    }

    private fun menuInferior(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }
}