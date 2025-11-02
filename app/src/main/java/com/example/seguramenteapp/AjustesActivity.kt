package com.example.seguramenteapp

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class AjustesActivity : Activity() {

    private lateinit var btnVolver: ImageButton
    private lateinit var switchNotificaciones: Switch
    private lateinit var switchUbicacion: Switch
    private lateinit var switchModoOscuro: Switch
    private lateinit var tvCambiarContrasena: TextView
    private lateinit var tvAcercaDe: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        btnVolver = findViewById(R.id.btnVolver)
        switchNotificaciones = findViewById(R.id.switchNotificaciones)
        switchUbicacion = findViewById(R.id.switchUbicacion)
        switchModoOscuro = findViewById(R.id.switchModoOscuro)
        tvCambiarContrasena = findViewById(R.id.tvCambiarContrasena)
        tvAcercaDe = findViewById(R.id.tvAcercaDe)

        btnVolver.setOnClickListener {
            finish()
        }

        setupSwitches()
        setupOptions()
    }

    private fun setupSwitches() {
        switchNotificaciones.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Notificaciones: ${if (isChecked) "Activadas" else "Desactivadas"}", Toast.LENGTH_SHORT).show()
        }

        switchUbicacion.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Ubicación: ${if (isChecked) "Activada" else "Desactivada"}", Toast.LENGTH_SHORT).show()
        }

        switchModoOscuro.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Modo oscuro: ${if (isChecked) "Activado" else "Desactivado"}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupOptions() {
        tvCambiarContrasena.setOnClickListener {
            Toast.makeText(this, "Cambiar contraseña", Toast.LENGTH_SHORT).show()
        }

        tvAcercaDe.setOnClickListener {
            Toast.makeText(this, "SeguraMente v1.0 - App de seguridad", Toast.LENGTH_LONG).show()
        }
    }
}
