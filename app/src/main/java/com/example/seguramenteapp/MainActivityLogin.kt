package com.example.seguramenteapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity1_login)


        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextPassword = findViewById<TextInputEditText>(R.id.editTextTextPassword)

        // ref al button btn_ir_recov
        val btnIrRecov = findViewById<Button>(R.id.btn_ir_recov)
        btnIrRecov.setOnClickListener{
            //crear intent
            val intent = Intent(this, PassRecovery1::class.java)
            // ejecutar intent:  Navegar a la activity PassRecovery1
            startActivity(intent)
        }

        val btnIrRegistro = findViewById<Button>(R.id.btn_regis)
        btnIrRegistro.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener{

            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese correo y contraseña", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, MenuOpcionesActivity::class.java)
                startActivity(intent)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}