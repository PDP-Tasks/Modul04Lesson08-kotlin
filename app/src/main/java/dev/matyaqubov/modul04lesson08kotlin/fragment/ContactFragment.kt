package dev.matyaqubov.modul04lesson08kotlin.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.activity.ThirdActivity
import dev.matyaqubov.modul04lesson08kotlin.adapter.ContactRecyclerViewAdapter
import dev.matyaqubov.modul04lesson08kotlin.model.Member

class ContactFragment : Fragment(){
    private lateinit var sendListener: SentObjectListener

    private lateinit var recyclerView: RecyclerView
    private lateinit var members:ArrayList<Member>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView=view.findViewById(R.id.rv_contact)
        recyclerView.layoutManager=GridLayoutManager(requireContext(),1)
        members=ArrayList()
        members=ThirdActivity().fillMembers()
        val adapter=ContactRecyclerViewAdapter(requireContext(),members)
        recyclerView.adapter=adapter
    }

    interface SentObjectListener{
        fun sendData(member: Member)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SentObjectListener){
            sendListener=context
        }
    }

}