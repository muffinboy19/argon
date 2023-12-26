package com.example.argon.Fragments.MainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.argon.Adapters.MainAdapter.MatchesAdapter
import com.example.argon.databinding.FragmentMatchBinding
import com.google.android.material.tabs.TabLayout

class Match : Fragment() {
    private lateinit var binding: FragmentMatchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addTab("Upcoming")
        addTab("Ongoing")
        addTab("Completed")


        binding.viewPager.adapter = MatchesAdapter(childFragmentManager, lifecycle)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

        val ongoingTabIndex = 1
        binding.viewPager.currentItem = ongoingTabIndex
    }

    private fun addTab(string: String) {
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(string))
    }
}