package dev.matyaqubov.modul04lesson08kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dev.matyaqubov.modul04lesson08kotlin.R
import dev.matyaqubov.modul04lesson08kotlin.adapter.ViewPagerAdapter
import dev.matyaqubov.modul04lesson08kotlin.fragment.*
import dev.matyaqubov.modul04lesson08kotlin.model.Member
import dev.matyaqubov.modul04lesson08kotlin.model.Post
import dev.matyaqubov.modul04lesson08kotlin.model.User

class FifthActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var posts: ArrayList<Post>
    private lateinit var members: ArrayList<Member>
    private lateinit var users: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        initViews()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewpager)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.add(ContactFragment(), "Contacts")
        viewPagerAdapter.add(UserFragment(), "Users")
        viewPagerAdapter.add(PostFragment(), "Posts")
        viewPager.setAdapter(viewPagerAdapter)
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)

    }

    fun fillPost(): ArrayList<Post> {
        posts = ArrayList()
        for (i in 0..10) {
            posts.add(Post("Bogibek Matyaqubov", "1h", "Linux is the best OS", R.drawable.one))
            posts.add(Post("Jo'rabek Matyaqubov", "2h", "Mac is the best OS", R.drawable.one))
        }
        return posts
    }

    fun fillMembers(): ArrayList<Member> {
        members = ArrayList()

        for (i in 0..13) {
            members.add(Member("Odilber", "+998942344432", R.drawable.icon_person))
            members.add(Member("Otabek", "+998945441524", R.drawable.icon_person))
        }
        return members
    }

    fun fillUsers(): ArrayList<User> {
        users = ArrayList()
        for (i in 0..13) {
            users.add(User("Azamat", "+998942344432"))
            users.add(User("Samandar", "+998945441524"))
        }
        return users
    }


}