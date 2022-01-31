package dev.matyaqubov.modul04lesson08kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.model.Post

class PostRecyclerAdapter(val context: Context,val posts:ArrayList<Post>)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PostViewHolder){
            val post=posts[position]
            holder.userFullName.text=post.userFullName
            holder.postText.text=post.postText
            holder.lastActive.text=post.lastActive
            holder.postImage.setImageResource(post.postImage)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(val view:View):RecyclerView.ViewHolder(view){
        val userFullName = view.findViewById<TextView>(R.id.tv_fullName);
        val lastActive = view.findViewById<TextView>(R.id.tv_last_active);
        val postText = view.findViewById<TextView>(R.id.tv_post);
        val postImage = view.findViewById<ImageView>(R.id.img_post);
    }

}