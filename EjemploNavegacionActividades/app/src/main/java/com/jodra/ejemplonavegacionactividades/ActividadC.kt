package com.jodra.ejemplonavegacionactividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.content.Intent

class ActividadC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_c)

        val mensaje = intent.getStringExtra("MENSAJE")
        val mensajeDeA = intent.getStringExtra("MENSAJEA")
        val boton = findViewById<Button>(R.id.btnbotonback)

        Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()

       boton.setOnClickListener{
          val intent = Intent(this, ActividadB::class.java)
           intent.putExtra("MENSAJE", mensajeDeA)
           startActivity(intent)
       }
    }
}