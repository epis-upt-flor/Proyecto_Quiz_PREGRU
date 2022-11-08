package com.example.pregru.ViewModel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.pregru.Model.Usuarios
import com.example.pregru.R
import com.example.pregru.ViewModel.adapter.viewholder.UserViewHolder

class UserAdapter(
    var list: List<Usuarios>,
    var onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<UserViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UserViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = list[position]
        holder.bindItem(item)
        holder.itemView.setOnClickListener {
            onItemClickListener.onClick(item, position)
        }
        holder.itemView.findViewById<Button>(R.id.delete).setOnClickListener {
            onItemClickListener.onDelete(item, position)
        }
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun onClick(item: Usuarios, position: Int)
        fun onDelete(item: Usuarios, position: Int)
    }


}