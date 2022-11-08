package com.example.pregru.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pregru.R

class ProfesorSesion : AppCompatActivity() {

    private lateinit var usuario_profesor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor_sesion)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombres")
        val apellido = bundle?.getString("apellidos")

        val nombre_usuario_profesor = findViewById<TextView>(R.id.txt_profesor)

        usuario_profesor = findViewById(R.id.txt_profesor)

        nombre_usuario_profesor.text = "BIENVENIDO PROFESOR(A) \t\n"+ nombre.toString().uppercase() + " " + apellido.toString().uppercase()
    }
}