package com.route.islami_42.ui.home

import HadethFragment
import HomeTabFragment
import RadioFragment
import SebhaFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islami_42.R
import com.route.islami_42.databinding.ActivityMainBinding
import com.route.islami_42.ui.home.tabs.time_tab.TimeFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigationBar()
        setupFragment(HomeTabFragment())

    }

    private fun setupBottomNavigationBar() {

        binding.bottomNavigationBar.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_home -> setupFragment(HomeTabFragment())
                R.id.navigation_hadeth -> setupFragment(HadethFragment())
                R.id.navigation_sebha -> setupFragment(SebhaFragment())
                R.id.navigation_radio -> setupFragment(RadioFragment())
                R.id.navigation_time -> setupFragment(TimeFragment())
            }

            return@setOnItemSelectedListener true
        }

    }

    private fun setupFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.fragments_container, fragment)
            .commit()

    }
}