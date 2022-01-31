package dev.matyaqubov.modul04lesson08kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.adapter.ViewPagerAdapter
import dev.matyaqubov.modul04lesson08kotlin.fragment.ContactFragment
import dev.matyaqubov.modul04lesson08kotlin.fragment.DetailFragment
import dev.matyaqubov.modul04lesson08kotlin.fragment.PageOneFragment
import dev.matyaqubov.modul04lesson08kotlin.fragment.PageTwoFragment
import dev.matyaqubov.modul04lesson08kotlin.model.Member
import java.util.ArrayList

class FourthActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        initViews()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewpager)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.add(PageOneFragment(), "Page 1")
        viewPagerAdapter.add(PageTwoFragment(), "Page 2")
        viewPagerAdapter.add(PageOneFragment(), "Page 3")
        viewPager.setAdapter(viewPagerAdapter)
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }
}