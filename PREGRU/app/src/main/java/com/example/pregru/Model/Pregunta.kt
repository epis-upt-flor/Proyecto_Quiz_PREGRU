package com.example.pregru.Model

data class Pregunta(
    var descripcion: String = "",
    var opcion1: String = "",
    var opcion2: String = "",
    var opcion3: String = "",
    var opcion4: String = "",
    var respuesta: String = "",
    var usuario_alumno: String = ""
)