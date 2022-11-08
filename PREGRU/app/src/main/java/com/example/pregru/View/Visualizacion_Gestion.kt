package com.example.pregru.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pregru.Model.Product
import com.example.pregru.Model.Usuarios
import com.example.pregru.R
import com.example.pregru.ViewModel.UserViewModel
import com.example.pregru.ViewModel.adapter.UserAdapter
import com.google.firebase.Timestamp

class Visualizacion_Gestion : AppCompatActivity(), UserAdapter.OnItemClickListener {

    private lateinit var name: EditText
    private lateinit var lastname: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var assignment: EditText
    private lateinit var submit: Button
    private lateinit var rvList: RecyclerView

    private lateinit var userAdapter: UserAdapter
    private lateinit var list: ArrayList<Usuarios>

    private var selected: Usuarios = Usuarios()

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizacion_gestion)

        initElement()
        initViewModel()



    }

    private fun initViewModel() {

        userViewModel.createLiveData.observe(this, {
            onCreate(it)
        })

        userViewModel.updateLiveData.observe(this, {
            onUpdate(it)
        })

        userViewModel.deleteLiveData.observe(this, {
            onDelete(it)
        })

        userViewModel.getListLiveData.observe(this, {
            onGetList(it)
        })


    }

    private fun initElement() {
        name = findViewById(R.id.nombre)
        lastname = findViewById(R.id.lastname)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        assignment = findViewById(R.id.assignment)
        submit = findViewById(R.id.submit)
        rvList = findViewById(R.id.rvList)

        list = ArrayList()

        submit.setOnClickListener {
            create()
        }

        // Get list
        userViewModel.getList()
    }

    private fun onCreate(it: Boolean) {
        if (it) {
            userViewModel.getList()
            resetText()
        }
    }

    private fun onUpdate(it: Boolean) {
        if (it) {
            userViewModel.getList()
            resetText()
        }
    }

    private fun onDelete(it: Boolean) {
        if (it) {
            userViewModel.getList()
            resetText()
        }
    }

    private fun onGetList(it: List<Usuarios>) {
        list = ArrayList()
        list.addAll(it)

        userAdapter = UserAdapter(list, this)

        rvList.adapter = userAdapter
        rvList.layoutManager = LinearLayoutManager(baseContext)

        userAdapter.notifyDataSetChanged()
    }

    private fun create() {
        val user = Usuarios(
            selected.id,
            name.text.toString(),
            lastname.text.toString(),
            assignment.text.toString(),
            email.text.toString(),
            password.text.toString(),
            selected.create_date ?: Timestamp.now(),
            selected.update_date
        )
        if (user.id != null) {
            userViewModel.update(user)
        } else {
            userViewModel.create(user)
        }
    }

    private fun resetText() {
        selected = Usuarios()

        name.text = null
        lastname.text = null
        assignment.text = null
        email.text = null
        password.text = null


    }

    override fun onClick(item: Usuarios, position: Int) {
        selected = item
        selected.update_date = Timestamp.now()

        name.setText(selected.name)
        lastname.setText(selected.lastname)
        assignment.setText(selected.assignment.toString())
        email.setText(selected.email)
        password.setText(selected.password)


    }

    override fun onDelete(item: Usuarios, position: Int) {
        userViewModel.delete(item.id!!)
    }


}