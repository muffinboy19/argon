package com.example.argon.Fragments.MainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.argon.Fragments.MoreFragment.AboutUs
import com.example.argon.Fragments.MoreFragment.Developers
import com.example.argon.Fragments.MoreFragment.Faq
import com.example.argon.Fragments.MoreFragment.Sponser
import com.example.argon.Fragments.MoreFragment.Team
import com.example.argon.R
import com.example.argon.databinding.FragmentMoreBinding

class More : Fragment() {
    private lateinit var binding: FragmentMoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.aboutLayout.setOnClickListener {
            loadFragment(AboutUs())
        }
        binding.teamLayout.setOnClickListener {
            loadFragment(Team())
        }
        binding.sponserLayout.setOnClickListener {
            loadFragment(Sponser())
        }
        binding.faqLayout.setOnClickListener {
            loadFragment(Faq())
        }
        binding.devLayout.setOnClickListener {
            loadFragment(Developers())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit()
    }
}