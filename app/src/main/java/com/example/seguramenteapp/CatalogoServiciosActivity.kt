package com.example.seguramenteapp

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatalogoServiciosActivity : Activity() {

    private lateinit var btnVolver: ImageButton
    private lateinit var recyclerServicios: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_servicios)

        btnVolver = findViewById(R.id.btnVolver)
        recyclerServicios = findViewById(R.id.recyclerServicios)

        btnVolver.setOnClickListener {
            finish()
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Lista de servicios de ejemplo
        val servicios = listOf(
            "Citas",
            "Tecnicas de respiración",
            "Consulta motivacional",
            "terapia individual",

        )

        recyclerServicios.layoutManager = LinearLayoutManager(this)
        // Aquí necesitarás crear un adaptador personalizado
        Toast.makeText(this, "Catálogo de ${servicios.size} servicios", Toast.LENGTH_SHORT).show()
    }
}
