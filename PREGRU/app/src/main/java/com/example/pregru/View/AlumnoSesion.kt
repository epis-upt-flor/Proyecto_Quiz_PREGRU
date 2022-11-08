package com.example.pregru.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pregru.R

class AlumnoSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno_sesion)


        val bundle = intent.extras
        val nombre = bundle?.getString("nombres")
        val apellido = bundle?.getString("apellidos")

        val nombre_usuario_alumno = findViewById<TextView>(R.id.txt_alumno)

        nombre_usuario_alumno.text = "BIENVENIDO ALUMNO(A) \t\n"+ nombre.toString().uppercase() + " " + apellido.toString().uppercase()

    }
}