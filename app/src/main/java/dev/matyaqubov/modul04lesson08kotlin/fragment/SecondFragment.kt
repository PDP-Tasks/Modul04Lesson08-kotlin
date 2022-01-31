package dev.matyaqubov.modul04lesson08kotlin.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.model.User
import java.lang.RuntimeException


class SecondFragment : Fragment() {

    private lateinit var textViewSecond: TextView
    private var listener:SecondListener?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_second, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        textViewSecond=view.findViewById(R.id.tv_second)
        val btnSecond=view.findViewById<Button>(R.id.btn_second)
        btnSecond.setOnClickListener {
            listener!!.onSecondSend("Academy")
        }
        view.findViewById<Button>(R.id.btn_obj2).setOnClickListener {
            listener!!.onSecondSend(User("Opabiyi","95125515215151"))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SecondListener){
            listener=context
        } else{
            throw RuntimeException(context.toString() + "xatolik")
        }
    }
    fun updateData(text:String){
        textViewSecond.text=text
    }
    fun updateData(user: User){
        textViewSecond.text=user.toString()
    }

    override fun onDetach() {
        super.onDetach()
        listener=null
    }

    public interface SecondListener{
        fun onSecondSend(text:String)
        fun onSecondSend(user: User)
    }
}