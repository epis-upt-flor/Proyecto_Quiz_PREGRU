package com.example.pregru.ViewModel.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pregru.Model.Product
import com.example.pregru.Model.Usuarios
import com.example.pregru.R

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.nameText)
    private val lastnameText: TextView = itemView.findViewById(R.id.lastnameText)
    private val emailText: TextView = itemView.findViewById(R.id.emailText)
    private val passwordText: TextView = itemView.findViewById(R.id.passwordText)
    private val assignmentText: TextView = itemView.findViewById(R.id.assignmentText)
    private val createDateText: TextView = itemView.findViewById(R.id.createDateText)
    private val updateDateText: TextView = itemView.findViewById(R.id.updateDateText)

    fun bindItem(usuario: Usuarios) {
        itemView.apply {
            nameText.text = usuario.name
            lastnameText.text = usuario.lastname
            assignmentText.text = usuario.assignment
            emailText.text = usuario.email
            passwordText.text = usuario.password
            createDateText.text = usuario.create_date!!.toDate().toString()

            if (usuario.update_date != null) {
                updateDateText.text = usuario.update_date!!.toDate().toString()
            }
        }
    }




}