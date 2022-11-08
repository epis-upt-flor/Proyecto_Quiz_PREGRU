package com.example.pregru.Model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class Usuarios(
    var id: String? = null,
    var name: String? = null,
    var lastname: String? = null,
    var assignment: String? = null,
    var email: String? = null,
    var password: String? = null,
    var create_date: Timestamp? = null,
    var update_date: Timestamp? = null
){
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "name" to name,
            "lastname" to lastname,
            "assignment" to assignment,
            "email" to email,
            "password" to password,
            "create_date" to create_date,
            "update_date" to update_date,

            )
    }

}