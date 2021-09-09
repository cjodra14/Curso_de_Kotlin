package com.jodra.solicitudeshttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import okhttp3.Call
import okhttp3.OkHttpClient
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.jvm.Throws

class MainActivity : AppCompatActivity(), CompletadoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bValidarRed = findViewById<Button>(R.id.bValidarRed)
        val bsolicitudHTTP = findViewById<Button>(R.id.bSolicitudHTTP)
        val bVolley = findViewById<Button>(R.id.bVolley)
        val bOk =findViewById<Button>(R.id.bOk)

        bValidarRed.setOnClickListener {
            //Código para validar la red
            if(Network.hayRed(this)){
                Toast.makeText(this, "Si, hay red", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No hay red, comprueba si hay conexión", Toast.LENGTH_LONG).show()
            }

        }

        bsolicitudHTTP.setOnClickListener{
            //Código para validar la red
            if(Network.hayRed(this)){
               //Log.d("bSolicitudOnCLick", descargarDatos("http://www.google.com"))
                DescargaURL(this).execute("http://www.google.com")
            }else{
                Toast.makeText(this, "No hay red, comprueba si hay conexión", Toast.LENGTH_LONG).show()
            }
        }

        bVolley.setOnClickListener {
            if(Network.hayRed(this)){
                solicitudHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id=3109453&appid=ad41e7c2459b1b0e1371fc408f7f3682")
            }else{
                Toast.makeText(this, "No hay red, comprueba si hay conexión", Toast.LENGTH_LONG).show()
            }
        }

        bOk.setOnClickListener {
            if(Network.hayRed(this)){
                    solicitudHTTPOkHTTP("http://www.google.com")
            }else{
                Toast.makeText(this, "No hay red, comprueba si hay conexión", Toast.LENGTH_LONG).show()
            }
        }


    }

    //Metodo OKHTTP

    private fun solicitudHTTPOkHTTP(url:String)
    {
        val cliente = OkHttpClient()
        val solicitud = okhttp3.Request.Builder().url(url).build()
        cliente.newCall(solicitud).enqueue(object: okhttp3.Callback{
            override fun onFailure(call: Call?, e:IOException?){

            }
            override fun onResponse(call: Call?, response: okhttp3.Response){
                val resultado = response.body().string()
                this@MainActivity.runOnUiThread{
                    try {
                        Log.d("solicitudHTTPOkHTTP", resultado)
                    }catch (e: Exception){

                    }
                }
            }
        })
    }



    // Método Volley
    private fun solicitudHTTPVolley(url:String){
        val queue = Volley.newRequestQueue( this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
            response ->
            try {
                Log.d("solicitudHTTPVolley", response)
            }catch (e:Exception){

            }
        },Response.ErrorListener{})
    queue.add(solicitud)
    }

    override fun descargaCompleta(resultado: String) {
        Log.d("descargaCompleta", resultado)
    }


    /*
    override fun descargaCompleta(resultado: String) {
       }*/


}