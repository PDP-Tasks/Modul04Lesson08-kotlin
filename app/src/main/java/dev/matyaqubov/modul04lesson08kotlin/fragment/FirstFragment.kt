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

class FirstFragment : Fragment() {
    private lateinit var textViewFirst: TextView
    private var listener: FirstListener?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        textViewFirst = view.findViewById(R.id.tv_first)
        val btnFirst = view.findViewById<Button>(R.id.btn_first)
        btnFirst.setOnClickListener {
            listener!!.onFirstSend("pdp")
        }
        view.findViewById<Button>(R.id.btn_obj).setOnClickListener {
            listener!!.onFirstSend(User("Otabek","98584512"))
        }
    }

     fun updateData(text:String){
        textViewFirst.text=text
    }
     fun updateData(user:User){
        textViewFirst.text=user.toString()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstListener) {
            listener = context
        } else{
            throw RuntimeException(context.toString()+ "xatooo")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener=null
    }

    public interface FirstListener {
        fun onFirstSend(text: String)
        fun onFirstSend(user: User)
    }

}