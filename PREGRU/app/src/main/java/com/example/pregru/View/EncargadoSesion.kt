package com.example.pregru.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pregru.R

class EncargadoSesion : AppCompatActivity() {

    private lateinit var gestar_usuario: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encargado_sesion)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombres")
        val apellido = bundle?.getString("apellidos")

        val nombre_usuario_encargado = findViewById<TextView>(R.id.txt_encargado)

        nombre_usuario_encargado.text = "BIENVENIDO GESTOR(A) \t\n"+ nombre.toString().uppercase() + " " + apellido.toString().uppercase()

        gestar_usuario = findViewById(R.id.btn_gestion_usuarios)

        gestar_usuario.setOnClickListener {
            val intent = Intent(this,Gestion_Usuarios::class.java)
            startActivity(intent)
            finish()
        }

    }
}