package com.example.skillsewapebblenew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.skillsewapebblenew.fragments.HomeFragment
import com.example.skillsewapebblenew.fragments.ProfileFragment
import com.example.skillsewapebblenew.fragments.ThirdFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var BottomNavigationView:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNavigationView = findViewById(R.id.bottomNavigationView)

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val thirdFragment = ThirdFragment()



        BottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Home -> makeCurrentfragment(homeFragment)
                R.id.Profile -> makeCurrentfragment(profileFragment)
                R.id.Settings -> makeCurrentfragment(thirdFragment)
            }
            return@setOnNavigationItemSelectedListener true
        }

        makeCurrentfragment(homeFragment)






    }

    private fun makeCurrentfragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.frameLayoutView, fragment)
            commit()
        }
    }
}