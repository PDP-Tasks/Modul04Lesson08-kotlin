package dev.matyaqubov.modul04lesson08kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.fragment.ContactFragment
import dev.matyaqubov.modul04lesson08kotlin.model.Member

class ContactRecyclerViewAdapter(val context: Context,var members:ArrayList<Member>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    private lateinit var listener:ContactFragment.SentObjectListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ContactViewHolder){
            val member=members[position]
            holder.imagePerson.setImageResource(member.photo)
            holder.tvName.text=member.name
            holder.tvPhone.text=member.phone
            holder.item.setOnClickListener {
                listener=context as ContactFragment.SentObjectListener
                listener.sendData(member)
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class ContactViewHolder(var view:View):RecyclerView.ViewHolder(view){
        val imagePerson=view.findViewById<ImageView>(R.id.img_photo)
        val tvName=view.findViewById<TextView>(R.id.tv_name)
        val tvPhone=view.findViewById<TextView>(R.id.tv_phone)
        val item=view.findViewById<LinearLayout>(R.id.ll_member)
    }

}