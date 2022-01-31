package dev.matyaqubov.modul04lesson08kotlin.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.activity.ThirdActivity
import dev.matyaqubov.modul04lesson08kotlin.adapter.ContactRecyclerViewAdapter
import dev.matyaqubov.modul04lesson08kotlin.model.Member
import java.util.ArrayList

class PageOneFragment : Fragment() {


    //    private TextView tvName,tvPhone;
    //    private ImageView imgPerson;
    private lateinit var members: ArrayList<Member>
    var activity: Activity? = getActivity() as ThirdActivity?
    private lateinit var recyclerView:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_contact, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv_contact)
        recyclerView.layoutManager=(GridLayoutManager(requireContext(), 1))
        members = ThirdActivity().fillMembers()
        val adapter = ContactRecyclerViewAdapter(ThirdActivity(), members)
        recyclerView.setAdapter(adapter)
    }


    interface ContactListener {
        fun onSendContact(member: Member?)
    }
}