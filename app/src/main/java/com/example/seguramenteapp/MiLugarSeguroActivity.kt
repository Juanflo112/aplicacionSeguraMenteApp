package com.example.seguramenteapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MiLugarSeguroActivity : Activity() {

    private lateinit var btnVolver: ImageButton
    private lateinit var etDireccion: EditText
    private lateinit var etReferencia: EditText
    private lateinit var btnSeleccionarMapa: Button
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_lugar_seguro)

        btnVolver = findViewById(R.id.btnVolver)

        btnVolver.setOnClickListener {
            finish()
        }


    }


}
