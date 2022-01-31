package dev.matyaqubov.modul04lesson08kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import dev.matyaqubov.modul04lesson08kotlin.R

class PageTwoFragment : Fragment() {
    private var tvName: TextView? = null
    private var tvPhone: TextView? = null
    private var imgPerson: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        tvName = view.findViewById(R.id.tv_detail_name)
        tvPhone = view.findViewById(R.id.tv_detail_phone)
        imgPerson = view.findViewById(R.id.img_person_detail)
    }


}