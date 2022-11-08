package com.example.pregru.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pregru.R

class Gestion_Usuarios : AppCompatActivity() {

    private lateinit var gestor_usuarios : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_usuarios)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombres")
        val apellido = bundle?.getString("apellidos")

        val nombre_usuario_encargado = findViewById<TextView>(R.id.txt_encargado)
        nombre_usuario_encargado.text = "BIENVENIDO GESTOR(A) \t\n"+ nombre.toString().uppercase() + " " + apellido.toString().uppercase()

        gestor_usuarios = findViewById(R.id.btn_gestion_crud_usuarios)

        gestor_usuarios.setOnClickListener {
            val intent = Intent(this,Visualizacion_Gestion::class.java)
            startActivity(intent)
            finish()
        }








    }
}