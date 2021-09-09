package com.jodra.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {

    val TAG = "com.jodra.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)
        val btnBrk =findViewById<Button>(R.id.btnBrk)
        val btnStz = findViewById<Button>(R.id.btnStz)
        val btnBi = findViewById<Button>(R.id.btnBi)
        val btnMus = findViewById<Button>(R.id.btnMus)

        btnBrk.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3109453")
            startActivity(intent)
            //Toast.makeText(this,"Barakaldo",Toast.LENGTH_SHORT).show()
        })
        btnStz.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3109481")
            startActivity(intent)
            //Toast.makeText(this, "Santurtzi",Toast.LENGTH_SHORT).show()
        })
        btnBi.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3128026")
            startActivity(intent)
           //Toast.makeText(this, "Bilbo",Toast.LENGTH_SHORT).show()
        })
        btnMus.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "6362413")
            startActivity(intent)
            //Toast.makeText(this, "Bilbo",Toast.LENGTH_SHORT).show()
        })
    }

}