package com.jodra.ejemplolistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var frutas:ArrayList<Fruta> = ArrayList()
        frutas.add(Fruta("Manzana",R.drawable.manzana))
        frutas.add(Fruta("Durazno",R.drawable.durazno))
        frutas.add(Fruta("Sandía",R.drawable.sandia))
        frutas.add(Fruta("Platano",R.drawable.platano))

        val lista= findViewById<ListView>(R.id.lista)

        //val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)
        val adaptador = AdaptadorCustom(this,frutas)
        lista.adapter=adaptador

        lista.onItemClickListener= AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, frutas.get(position).nombreFruta, Toast.LENGTH_LONG).show()
        }

    }
}