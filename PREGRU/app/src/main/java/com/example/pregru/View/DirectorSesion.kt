package com.example.pregru.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pregru.R

class DirectorSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_director_sesion)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombres")
        val apellido = bundle?.getString("apellidos")

        val nombre_usuario_director = findViewById<TextView>(R.id.txt_director)

        nombre_usuario_director.text = "BIENVENIDO DIRECTOR(A) \t\n"+ nombre.toString().uppercase() + " " + apellido.toString().uppercase()
    }
}