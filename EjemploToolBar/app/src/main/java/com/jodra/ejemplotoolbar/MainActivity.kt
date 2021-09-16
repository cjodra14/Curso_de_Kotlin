package com.jodra.ejemplotoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {


    private var toolbar: Toolbar?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar= findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

    }
}