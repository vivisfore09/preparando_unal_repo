package com.example.preparando_unal

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.preparando_unal.databinding.RegistrarMascotaActivityBinding
import java.io.File


class RegistrarMascota: AppCompatActivity() {

    lateinit var binding: RegistrarMascotaActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= RegistrarMascotaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email=intent.getStringExtra("email")
        Toast.makeText(this,"$email", Toast.LENGTH_LONG).show()

       binding.tomarFoto.setOnClickListener{
       val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{
           crearFotoFile()
           val fotoUri = FileProvider.getUriForFile(this,BuildConfig.APPLICATION_ID+".fileprovider", file)
        it.putExtra(MediaStore.EXTRA_OUTPUT,fotoUri)
       }
       abrircamara.launch(intent)

       // abrircamara.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            }

        binding.regsitrarMas.setOnClickListener{
            if (email != null) {
                guardarUsuario(email)
            }else{
                Toast.makeText(this,"No hay Usuario", Toast.LENGTH_LONG).show()
            }
        }
        }

    val abrircamara=
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == RESULT_OK){
                val data = result.data!!
                //val bitmap = data?.extras?.get("data") as Bitmap
                val bitmap = BitmapFactory.decodeFile(file.toString())
                binding.imagenTomada.setImageBitmap(bitmap)
            }
        }
    private lateinit var file: File
    private fun crearFotoFile() {
       val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        file = File.createTempFile("Foto_${System.currentTimeMillis()}_",".jpg",dir)
    }

    fun guardarUsuario(email:String){

        val nombre: String = binding.nombre.text.toString()
        val tipo: String = binding.tipo.text.toString()
        val raza: String = binding.raza.text.toString()
        val color: String = binding.color.text.toString()
        val foto: String = file.toString()
        val sexo: Int= binding.sexo.id

        var pref=getSharedPreferences("${email}_$nombre", Context.MODE_PRIVATE)
        var edit=pref.edit()

        edit.putString("id_mascota","${email}_$nombre") //id_mascota
        edit.putString("usuario",email)
        edit.putString("nombre_mascota",nombre)
        edit.putString("tipo_mascota",tipo)
        edit.putString("raza_mascota",raza)
        edit.putString("color_mascota",color)
        edit.putString("foto_mascota",foto)
        if(sexo==0){
            edit.putString("sexo","Hembra")
        }else{
            edit.putString("sexo","Macho")
        }
        edit.commit()
        Toast.makeText(this,"Mascota registrada exitosamente.", Toast.LENGTH_LONG).show()
    }

}


