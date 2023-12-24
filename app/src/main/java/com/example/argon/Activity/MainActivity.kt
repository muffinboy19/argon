package com.example.argon.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.argon.Fragments.MainFragment.Event
import com.example.argon.Fragments.MainFragment.Home
import com.example.argon.Fragments.MainFragment.More
import com.example.argon.Fragments.MainFragment.Points_Table
import com.example.argon.Fragments.MainFragment.Schedule
import com.example.argon.R
import com.example.argon.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private fun onNavigationItemSelected(fragment: Fragment): Boolean {
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer)?.javaClass != fragment::class.java) {
            loadFragment(fragment)
        }
        return true
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navEvents -> return@OnNavigationItemSelectedListener onNavigationItemSelected(
                    Event()
                )

                R.id.navSchedule -> return@OnNavigationItemSelectedListener onNavigationItemSelected(
                    Schedule()
                )

                R.id.navHome -> return@OnNavigationItemSelectedListener onNavigationItemSelected(
                    Home()
                )

                R.id.navMore -> return@OnNavigationItemSelectedListener onNavigationItemSelected(
                    More()
                )

                R.id.navPoint -> return@OnNavigationItemSelectedListener onNavigationItemSelected(
                    Points_Table()
                )
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavBar.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )
        loadFragment(Home())
        binding.bottomNavBar.selectedItemId = R.id.navHome

    }

    private fun loadFragment(fragment: Fragment) {
        when (fragment) {
            is Event, is Schedule, is Home, is More, is Points_Table -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
                    .commit()
            }
        }
    }

}