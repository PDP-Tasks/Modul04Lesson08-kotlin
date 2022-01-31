
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
import dev.matyaqubov.modul04lesson08kotlin.model.Member
import dev.matyaqubov.modul04lesson08kotlin.model.Post


class PostFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var posts:ArrayList<Post>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
       val view= inflater.inflate(R.layout.fragment_post, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView=view.findViewById(R.id.rv_post)
        recyclerView.layoutManager= GridLayoutManager(requireContext(),1)
        posts=ArrayList()
        posts=FifthActivity().fillPost()
        val adapter=PostRecyclerAdapter(requireContext(),posts)
        recyclerView.adapter=adapter
    }

}