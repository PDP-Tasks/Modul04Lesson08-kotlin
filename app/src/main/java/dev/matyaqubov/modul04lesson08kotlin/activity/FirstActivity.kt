package dev.matyaqubov.modul04lesson08kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.fragment.FirstFragment
import dev.matyaqubov.modul04lesson08kotlin.fragment.SecondFragment
import dev.matyaqubov.modul04lesson08kotlin.model.User

class FirstActivity : AppCompatActivity() ,FirstFragment.FirstListener,SecondFragment.SecondListener {

    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initViews()
    }

    private fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_first, firstFragment)
            .replace(R.id.fr_second, secondFragment).commit()
    }

    override fun onFirstSend(text: String) {
        secondFragment.updateData(text)
    }

    override fun onFirstSend(user: User) {

    }

    override fun onSecondSend(text: String) {
        firstFragment.updateData(text)
    }

    override fun onSecondSend(user: User) {

    }
}