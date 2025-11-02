package com.example.seguramenteapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PassRecovery1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity2_pass_recovery1)

        // ref al button btn_send_recov
        val btnIrRecov = findViewById<Button>(R.id.btn_send_recov)
        btnIrRecov.setOnClickListener{
            //crear intent
            val intent = Intent(this, MainActivity::class.java)
            // ejecutar intent:  Navegar a la activity MainActivity
            startActivity(intent)
        }

        // ref al button btn_regis_2
        val btn_regis_2 = findViewById<Button>(R.id.btn_regis_2)
        btn_regis_2.setOnClickListener{
            //crear intent
            val intent = Intent(this, RegistroActivity::class.java)
            // ejecutar intent:  Navegar a la activity RegistroActivity
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}