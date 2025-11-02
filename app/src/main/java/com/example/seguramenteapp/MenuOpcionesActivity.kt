package com.example.seguramenteapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast

class MenuOpcionesActivity : Activity() {

    private lateinit var menuCatalogoServicios: LinearLayout
    private lateinit var menuMiLugarSeguro: LinearLayout
    private lateinit var menuAjustes: LinearLayout
    private lateinit var menuCerrarSesion: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_opciones)

        // Inicializar vistas
        menuCatalogoServicios = findViewById(R.id.menuCatalogoServicios)
        menuMiLugarSeguro = findViewById(R.id.menuMiLugarSeguro)
        menuAjustes = findViewById(R.id.menuAjustes)
        menuCerrarSesion = findViewById(R.id.menuCerrarSesion)

        // Configurar listeners con animaciones
        setupMenuOption(menuCatalogoServicios) {
            // Navegar a Catálogo de Servicios
            val intent = Intent(this, CatalogoServiciosActivity::class.java)
            startActivity(intent)
        }

        setupMenuOption(menuMiLugarSeguro) {
            // Navegar a Mi Lugar Seguro
            val intent = Intent(this, MiLugarSeguroActivity::class.java)
            startActivity(intent)
        }

        setupMenuOption(menuAjustes) {
            // Navegar a Ajustes
            val intent = Intent(this, AjustesActivity::class.java)
            startActivity(intent)
        }

        setupMenuOption(menuCerrarSesion) {
            // Cerrar sesión
            cerrarSesion()
        }
    }

    private fun setupMenuOption(layout: LinearLayout, action: () -> Unit) {
        layout.setOnClickListener {
            // Animación de escala al hacer clic
            it.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction {
                    it.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                        .withEndAction {
                            action()
                        }
                        .start()
                }
                .start()
        }

        // Efecto visual al presionar
        layout.setOnTouchListener { view, event ->
            when (event.action) {
                android.view.MotionEvent.ACTION_DOWN -> {
                    view.alpha = 0.7f
                }
                android.view.MotionEvent.ACTION_UP, android.view.MotionEvent.ACTION_CANCEL -> {
                    view.alpha = 1f
                }
            }
            false
        }
    }

    private fun cerrarSesion() {
        // Limpiar datos de sesión si es necesario
        Toast.makeText(this, "Cerrando sesión...", Toast.LENGTH_SHORT).show()
        
        // Volver a la pantalla de login
        val intent = Intent(this, MainActivityLogin::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
