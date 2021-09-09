package com.jodra.ejemplogridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var frutas = ArrayList<Fruta>()

        frutas.add(Fruta("Manzana",R.drawable.manzana))
        frutas.add(Fruta("Platano",R.drawable.platano))
        frutas.add(Fruta("Sandía",R.drawable.sandia))
        frutas.add(Fruta("Durazno",R.drawable.durazno))
        frutas.add(Fruta("Manzana",R.drawable.manzana))
        frutas.add(Fruta("Platano",R.drawable.platano))
        frutas.add(Fruta("Sandía",R.drawable.sandia))
        frutas.add(Fruta("Durazno",R.drawable.durazno))
        frutas.add(Fruta("Manzana",R.drawable.manzana))
        frutas.add(Fruta("Platano",R.drawable.platano))
        frutas.add(Fruta("Sandía",R.drawable.sandia))
        frutas.add(Fruta("Durazno",R.drawable.durazno))
        frutas.add(Fruta("Manzana",R.drawable.manzana))
        frutas.add(Fruta("Platano",R.drawable.platano))
        frutas.add(Fruta("Sandía",R.drawable.sandia))
        frutas.add(Fruta("Durazno",R.drawable.durazno))

        var grid: GridView = findViewById(R.id.grid)
        val adaptador = AdaptadorCustom(this, frutas)
        //val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)
        grid.adapter = adaptador
        grid. onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, frutas.get(position).nombreFruta,Toast.LENGTH_SHORT).show()
        }

    }
}