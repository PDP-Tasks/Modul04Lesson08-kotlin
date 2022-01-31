package dev.matyaqubov.modul04lesson08kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.fragment.ContactFragment
import dev.matyaqubov.modul04lesson08kotlin.fragment.PostFragment
import dev.matyaqubov.modul04lesson08kotlin.fragment.UserFragment

class BackStackandInitialValuesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stackand_initial_values)
        initViews()
        replaceFragment(ContactFragment())
    }

    private fun initViews() {
        val contactButton=findViewById<Button>(R.id.btn_contact)
        contactButton.setOnClickListener {
            replaceFragment(ContactFragment())
        }
        val userButton=findViewById<Button>(R.id.btn_user)
        userButton.setOnClickListener {
            replaceFragment(UserFragment())
        }
        val postButton=findViewById<Button>(R.id.btn_post)
        postButton.setOnClickListener {
            replaceFragment(PostFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val backStateName=fragment.javaClass.name
        val manager=supportFragmentManager
        val fragmentPopped=manager.popBackStackImmediate(backStateName,0)
        if (!fragmentPopped){
            val ft=manager.beginTransaction()
                .replace(R.id.frameL,fragment)
                .addToBackStack(backStateName)
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount==1){
            finish()
        }
        super.onBackPressed()
    }
}