package dev.matyaqubov.modul04lesson08kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul04lesson08kotlin.R

import dev.matyaqubov.modul04lesson08kotlin.model.User

class UserRecyclerViewAdapter(val context: Context, val users: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            val user = users[position]
            holder.name.text = user.name
            holder.phone.text = user.phone

        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tv_name);
        val phone = view.findViewById<TextView>(R.id.tv_phone);

    }

}