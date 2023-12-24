package com.example.argon.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.argon.Adapter.TeamAdapter
import com.example.argon.DataClass.TeamMember
import com.example.argon.DataClass.TeamSection
import com.example.argon.R
import com.example.argon.databinding.FragmentTeamBinding

class Team : Fragment() {

    private lateinit var binding: FragmentTeamBinding
    private var teamSections:List<TeamSection> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTeamBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamSections = initializeTeamData()
        binding.teamRv.adapter = TeamAdapter(requireContext(),teamSections)
        binding.teamRv.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun initializeTeamData(): List<TeamSection> {
        // Add your team members and sections here
        // Example:
        val festiveCordiMembers = listOf(
            TeamMember("Member1", "Role1"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2"),
            TeamMember("Member2", "Role2")
            // Add more members as needed
        )
        val financeMembers = listOf(
            TeamMember("Member3", "Role3"),
            TeamMember("Member4", "Role4")
            // Add more members as needed
        )
        // Add more sections as needed
        return listOf(
            TeamSection("Festive Cordi", festiveCordiMembers),
            TeamSection("Finance", financeMembers)
            // Add more sections as needed
        )
    }

}