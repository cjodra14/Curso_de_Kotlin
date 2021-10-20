package com.jodra.ejemplotoolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat

class MainActivity : AppCompatActivity() {


    private var toolbar: Toolbar?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar= findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        val btnIr =findViewById<Button>(R.id.btnIr)


        btnIr.setOnClickListener {
            val intent = Intent( this, PantallaDos::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val itemBusqueda = menu?.findItem(R.id.btnBusqueda)
        val vistaBusqueda = itemBusqueda?.actionView as androidx.appcompat.widget.SearchView
        val itemCompartir = menu?.findItem(R.id.share)
        val shareActionProvider= MenuItemCompat.getActionProvider(itemCompartir) as ShareActionProvider
        compartirIntent(shareActionProvider)


        vistaBusqueda.queryHint = getString(R.string.search_hint)

        vistaBusqueda.setOnQueryTextFocusChangeListener { v, hasFocus ->
            Log.d("LISTENERFOCUS", hasFocus.toString())
        }
        vistaBusqueda.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("onQueryTextChange",newText!!)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("OnQueryTextSubmit", query!!)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btnFavorito -> {
                Toast.makeText(this, "Elemento añadido a favorito", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {return super.onOptionsItemSelected(item)}
        }
        return super.onOptionsItemSelected(item)
    }

    private fun compartirIntent(shareActionProvider: ShareActionProvider){
        if(shareActionProvider != null){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un mensaje compartido")
            shareActionProvider.setShareIntent(intent)
        }
    }
}