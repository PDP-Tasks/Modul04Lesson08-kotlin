package dev.matyaqubov.modul04lesson08kotlin.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.model.Member

class DetailFragment : Fragment() {
    private lateinit var tvName: TextView
    private  lateinit var tvPhone:TextView
    private lateinit var imgPerson: ImageView
    private lateinit var imgphone:ImageView
    lateinit var listener: ClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view =inflater.inflate(R.layout.fragment_detail, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view :View) {
        imgphone=view.findViewById(R.id.img_phone)
        tvName = view.findViewById(R.id.tv_detail_name)
        tvPhone = view.findViewById(R.id.tv_detail_phone)
        imgPerson = view.findViewById(R.id.img_person_detail)
        imgphone.setOnClickListener {
            listener.onClick()
        }
    }

    fun updateData(member: Member) {
        tvName.text=member.name
        tvPhone.text=member.phone
        imgPerson.setImageResource(member.photo)
    }
    interface ClickListener{
        fun onClick()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener){
            listener=context
        }
    }

}