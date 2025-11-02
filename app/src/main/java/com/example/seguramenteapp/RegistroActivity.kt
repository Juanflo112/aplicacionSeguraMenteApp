package com.example.seguramenteapp

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import java.util.Calendar
import java.util.regex.Pattern

class RegistroActivity : Activity() {

    private lateinit var etNombresApellidos: EditText
    private lateinit var etDocumento: EditText
    private lateinit var etFechaNacimiento: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etDireccion: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etContrasena: EditText
    private lateinit var etConfirmarContrasena: EditText
    private lateinit var ivShowPassword: ImageView
    private lateinit var ivShowConfirmPassword: ImageView
    private lateinit var btnCrearCuenta: Button
    private lateinit var btnAtras: LinearLayout
    private var isPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        initViews()
        setupListeners()
    }

    private fun initViews() {
        etNombresApellidos = findViewById(R.id.etNombresApellidos)
        etDocumento = findViewById(R.id.etDocumento)
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento)
        etTelefono = findViewById(R.id.etTelefono)
        etDireccion = findViewById(R.id.etDireccion)
        etCorreo = findViewById(R.id.etCorreo)
        etContrasena = findViewById(R.id.etContrasena)
        etConfirmarContrasena = findViewById(R.id.etConfirmarContrasena)
        ivShowPassword = findViewById(R.id.ivShowPassword)
        ivShowConfirmPassword = findViewById(R.id.ivShowConfirmPassword)
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta)
        btnAtras = findViewById(R.id.btnAtras)
    }

    private fun setupListeners() {
        etFechaNacimiento.setOnClickListener { showDatePicker() }
        ivShowPassword.setOnClickListener { togglePasswordVisibility() }
        ivShowConfirmPassword.setOnClickListener { toggleConfirmPasswordVisibility() }
        btnCrearCuenta.setOnClickListener { validateAndCreateAccount() }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val date = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear)
                etFechaNacimiento.setText(date)
            }, year, month, day)

        datePickerDialog.show()
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            etContrasena.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            ivShowPassword.setImageResource(R.drawable.ic_eye)
        } else {
            etContrasena.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            ivShowPassword.setImageResource(R.drawable.ic_eye_off)
        }
        etContrasena.setSelection(etContrasena.length())
        isPasswordVisible = !isPasswordVisible
    }

    private fun toggleConfirmPasswordVisibility() {
        if (isConfirmPasswordVisible) {
            etConfirmarContrasena.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            ivShowConfirmPassword.setImageResource(R.drawable.ic_eye)
        } else {
            etConfirmarContrasena.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            ivShowConfirmPassword.setImageResource(R.drawable.ic_eye_off)
        }
        etConfirmarContrasena.setSelection(etConfirmarContrasena.length())
        isConfirmPasswordVisible = !isConfirmPasswordVisible
    }

    private fun validateAndCreateAccount() {
        val nombres = etNombresApellidos.text.toString().trim()
        val documento = etDocumento.text.toString().trim()
        val fecha = etFechaNacimiento.text.toString().trim()
        val telefono = etTelefono.text.toString().trim()
        val direccion = etDireccion.text.toString().trim()
        val correo = etCorreo.text.toString().trim()
        val contrasena = etContrasena.text.toString()
        val confirmarContrasena = etConfirmarContrasena.text.toString()

        if (nombres.isEmpty() || documento.isEmpty() || fecha.isEmpty() || 
            telefono.isEmpty() || direccion.isEmpty() || correo.isEmpty() || 
            contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        if (!isValidEmail(correo)) {
            Toast.makeText(this, "Ingrese un correo válido", Toast.LENGTH_SHORT).show()
            return
        }

        if (!isValidPassword(contrasena)) {
            Toast.makeText(this, "La contraseña debe tener mínimo 8 caracteres, incluir símbolos, una mayúscula y un número", Toast.LENGTH_LONG).show()
            return
        }

        if (contrasena != confirmarContrasena) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordPattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
        return Pattern.matches(passwordPattern, password)
    }
}
