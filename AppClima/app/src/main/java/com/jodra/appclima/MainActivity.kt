package com.jodra.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstado:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstado = findViewById(R.id.tvEstado)



        val ciudad = intent.getStringExtra("com.jodra.appclima.ciudades.CIUDAD")

        if(Network.hayRed(this)){
            //ejecutar solicitudhttp
            Toast.makeText(this, "Hay red", Toast.LENGTH_LONG).show()
            solicitudHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=ad41e7c2459b1b0e1371fc408f7f3682&lang=es&units=metric")
            //ad41e7c2459b1b0e1371fc408f7f3682
            //3109453 Barakaldo
            //3109481 Santurtzi
            //3128026 Bilbo
            println("Hay red")
        }else{
            //Mostrar mensaje
            Toast.makeText(this, "No hay red, comprueba si hay conexión", Toast.LENGTH_LONG).show()
        }
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()
        /*val ciudadBrk= Ciudad("Barakaldo",15,"Nublado")
        val ciudadStz = Ciudad("Santurtzi", 17,"Soleado")
        val ciudadBi = Ciudad ("Bilbo",16, "Cielo despejado")



        if (ciudad=="ciudad-barakaldo"){
            //mostrar barakaldo
            tvCiudad?.text = ciudadBrk.nombre
            tvGrados?.text = ciudadBrk.grados.toString()+"ºC"
            tvEstado?.text = ciudadBrk.estado
        }else if(ciudad == "ciudad-santurtzi"){
            //Mostrar Santurtzi
            tvCiudad?.text = ciudadStz.nombre
            tvGrados?.text = ciudadStz.grados.toString()+"ºC"
            tvEstado?.text = ciudadStz.estado
        }else if(ciudad == "ciudad-bilbo"){
            //Mostrar Bilbo
            tvCiudad?.text = ciudadBi.nombre
            tvGrados?.text = ciudadBi.grados.toString()+"ºC"
            tvEstado?.text = ciudadBi.estado
        }else{
            Toast.makeText(this, "No se encuentra la información",Toast.LENGTH_LONG).show()
        }*/
    }
    // Método Volley
    fun solicitudHTTPVolley(url:String){
        val queue = Volley.newRequestQueue( this)
        val solicitud = StringRequest(Request.Method.GET, url, {
                response ->
            try {
                Log.d("solicitudHTTPVolley", response)
                val gson= Gson()
                val ciudad = gson.fromJson(response,Ciudad::class.java)
                tvCiudad?.text = ciudad.name
                tvGrados?.text = ciudad.main?.temp.toString()+"ºC"
                tvEstado?.text = ciudad.weather?.get(0)?.description
                //Log.d("GSON", ciudad.name)
            }catch (e:Exception){
                    e.printStackTrace()
            }
        }, {})
        queue.add(solicitud)
    }

}