package dev.matyaqubov.modul04lesson08kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.fragment.ContactFragment
import dev.matyaqubov.modul04lesson08kotlin.fragment.DetailFragment
import dev.matyaqubov.modul04lesson08kotlin.model.Member

class ThirdActivity : AppCompatActivity(), ContactFragment.SentObjectListener,DetailFragment.ClickListener {
    private lateinit var contactFragment: ContactFragment
    private lateinit var detailFragment: DetailFragment
    private lateinit var detailfrLayout: FrameLayout
    private lateinit var members: ArrayList<Member>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        initViews()
    }

    private fun initViews() {
        contactFragment = ContactFragment()
        detailFragment = DetailFragment()
        detailfrLayout = findViewById<FrameLayout>(R.id.fr_details)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_contacts, contactFragment)
            .replace(R.id.fr_details, detailFragment).commit()
    }

    fun fillMembers(): ArrayList<Member> {
        members = ArrayList()
        for (i in 0..6) {
            members.add(Member("Alisher", "+998972529712", R.drawable.icon_person))
            members.add(Member("Azamat", "+998942344432", R.drawable.icon_person))
            members.add(Member("Otabek", "+98589259545", R.drawable.icon_person))
        }
        return members
    }

    override fun sendData(member: Member) {
        Log.d("memberjon: ", "onClick: ${member.toString()}")
        detailfrLayout.visibility = View.VISIBLE
        detailFragment.updateData(member)
    }

    override fun onClick() {
        detailfrLayout.visibility=View.GONE
    }

}
