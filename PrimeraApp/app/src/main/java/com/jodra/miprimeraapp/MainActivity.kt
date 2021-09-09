package com.jodra.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bSaludar = findViewById<Button>(R.id.bSaludar)
        val edNombre=findViewById<EditText>(R.id.edNombre)
        val cbDev=findViewById<CheckBox>(R.id.cbDesarrollador)
        bSaludar.setOnClickListener(View.OnClickListener {

            if (validarDato()){
                if (cbDev.isChecked){
                    Toast.makeText(this, "Bienvenido, "+edNombre.text+", eres un desarrollado", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Bienvenido, "+edNombre.text+"!", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this, "Escribe tu nombre", Toast.LENGTH_SHORT).show()
            }


        })
    }


    fun validarDato(): Boolean{

        val etNombre=findViewById<EditText>(R.id.edNombre)
        val nombreUsuario= etNombre.text

        if(nombreUsuario.isNullOrEmpty()){
            return false
        }

        return true
    }
}