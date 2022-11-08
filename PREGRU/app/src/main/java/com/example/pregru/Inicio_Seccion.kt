package com.example.pregru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pregru.View.AlumnoSesion
import com.example.pregru.View.DirectorSesion
import com.example.pregru.View.EncargadoSesion
import com.example.pregru.View.ProfesorSesion
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Inicio_Seccion : AppCompatActivity() {

    private lateinit var auth: Firebase

    val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_seccion)

        val mcorreo = findViewById<EditText>(R.id.txt_correo)

        val boton_iniciar_seccion = findViewById<Button>(R.id.btn_iniciar)

        val mpassword = findViewById<EditText>(R.id.txt_password)


        val db_usuario = db.collection("users")


        boton_iniciar_seccion.setOnClickListener{
            val rcorreo = mcorreo.text.toString()
            val rpassword = mpassword.text.toString()

            db_usuario.get().addOnSuccessListener { documents ->

                for (document in documents) {

                    val datacorreo = document.data?.get("email")
                    val datapassword = document.data?.get("password")
                    val datarol = document.data?.get("assignment").toString().toInt()
                    val nombres = document.data?.get("name")
                    val apellidos = document.data?.get("lastname")


                    if(rcorreo == datacorreo && rpassword == datapassword){

                        when(datarol){

                            1 -> {
                                val intent = Intent(this, AlumnoSesion::class.java)
                                intent.putExtra("nombres",nombres.toString())
                                intent.putExtra("apellidos",apellidos.toString())
                                startActivity(intent)
                                break
                            }

                            2 -> {
                                val intent = Intent(this, ProfesorSesion::class.java)
                                intent.putExtra("nombres",nombres.toString())
                                intent.putExtra("apellidos",apellidos.toString())
                                startActivity(intent)
                                break

                            }

                            3 -> {
                                val intent = Intent(this, DirectorSesion::class.java)
                                intent.putExtra("nombres",nombres.toString())
                                intent.putExtra("apellidos",apellidos.toString())
                                startActivity(intent)
                                break
                            }

                            4 -> {
                                val intent = Intent(this, EncargadoSesion::class.java)
                                intent.putExtra("nombres",nombres.toString())
                                intent.putExtra("apellidos",apellidos.toString())
                                startActivity(intent)
                                break

                            }else -> {
                            Toast.makeText(baseContext, "No se pudo acceder al aplicativo"
                                , Toast.LENGTH_SHORT).show()

                            }

                        }


                    }

                }
            }

        }

    }
}


