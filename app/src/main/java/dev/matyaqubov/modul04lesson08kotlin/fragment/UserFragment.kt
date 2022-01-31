package dev.matyaqubov.modul04lesson08kotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.activity.FifthActivity
import dev.matyaqubov.modul04lesson08kotlin.adapter.PostRecyclerAdapter
import dev.matyaqubov.modul04lesson08kotlin.adapter.UserRecyclerViewAdapter
import dev.matyaqubov.modul04lesson08kotlin.model.Post
import dev.matyaqubov.modul04lesson08kotlin.model.User

class UserFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var users:ArrayList<User>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView=view.findViewById(R.id.rv_user)
        recyclerView.layoutManager= GridLayoutManager(requireContext(),1)
        users=ArrayList()
        users= FifthActivity().fillUsers()
        val adapter= UserRecyclerViewAdapter(requireContext(),users)
        recyclerView.adapter=adapter
    }

}