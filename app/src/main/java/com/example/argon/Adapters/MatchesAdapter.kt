package com.example.argon.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.argon.Fragments.MatchFrgament.Completed
import com.example.argon.Fragments.MatchFrgament.Ongoing
import com.example.argon.Fragments.MatchFrgament.Upcoming

class MatchesAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> {
                Ongoing()
            }

            0 -> {
                Upcoming()
            }

            else -> {
                Completed()
            }
        }
    }
}
