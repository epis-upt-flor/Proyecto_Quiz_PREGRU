package com.example.pregru.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pregru.Model.Usuarios
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserViewModel: ViewModel() {

    private var db = Firebase.firestore
    private val usuarios = "users"

    val createLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val updateLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val getListLiveData: MutableLiveData<List<Usuarios>> by lazy {
        MutableLiveData<List<Usuarios>>()
    }

    val deleteLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun create(usuario: Usuarios) {
        val docRef = db.collection(usuarios)
        docRef.add(usuario.toMap()).addOnSuccessListener {
            createLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("create", it.localizedMessage!!)
            createLiveData.postValue(false)
        }
    }

    fun update(usuario: Usuarios) {
        val docRef = db.collection(usuarios)
        docRef.document(usuario.id!!).update(usuario.toMap()).addOnSuccessListener {
            updateLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("update", it.localizedMessage!!)
            updateLiveData.postValue(false)
        }
    }

    fun delete(id: String) {
        val docRef = db.collection(usuarios)
        docRef.document(id).delete().addOnSuccessListener {
            deleteLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("delete", it.localizedMessage!!)
            deleteLiveData.postValue(false)
        }
    }

    fun getList() {
        val docRef = db.collection(usuarios)
        docRef.get().addOnSuccessListener {
            val users = ArrayList<Usuarios>()
            for (item in it.documents) {
                val user = Usuarios()
                user.id = item.id
                user.name = item.data!!["name"] as String?
                user.assignment = item.data!!["assignment"] as String?
                user.lastname = item.data!!["lastname"] as String?
                user.email = item.data!!["email"] as String?
                user.password = item.data!!["password"] as String?
                user.create_date = item.data!!["create_date"] as Timestamp?
                user.update_date = item.data!!["update_date"] as Timestamp?
                users.add(user)
            }

            getListLiveData.postValue(users)
        }.addOnFailureListener {
            Log.d("get", it.localizedMessage!!)
            getListLiveData.postValue(null)
        }
    }



}