package com.example.argon.Fragments.MoreFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.argon.Adapters.TeamAdapter.TeamAdapter
import com.example.argon.DataClass.TeamMember
import com.example.argon.DataClass.TeamSection
import com.example.argon.databinding.FragmentTeamBinding
import com.google.firebase.firestore.FirebaseFirestore

class Team : Fragment() {

    private lateinit var binding: FragmentTeamBinding
    private var teamSections: MutableList<TeamSection> = mutableListOf()
    private lateinit var teamAdapter: TeamAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamAdapter = TeamAdapter(requireContext(), teamSections)
        binding.teamRv.adapter = teamAdapter
        binding.teamRv.layoutManager = LinearLayoutManager(requireContext())
        fetchFromFirestore()
    }

    private fun fetchFromFirestore() {
        teamSections.clear()
        val db = FirebaseFirestore.getInstance()
        db.collection("Team").orderBy("no").get().addOnSuccessListener { documents ->
            val wingMap = mutableMapOf<String, MutableList<TeamMember>>()
            for (document in documents) {
                val name = document.getString("name") ?: ""
                val role = document.getString("role") ?: ""
                val wing = document.getString("wing") ?: ""
                val teamMember = TeamMember(name, role)
                if (wingMap.containsKey(wing)) {
                    wingMap[wing]?.add(teamMember)
                } else {
                    wingMap[wing] = mutableListOf(teamMember)
                }
            }
            for ((wing, members) in wingMap) {
                val teamSection = TeamSection(wing, members)
                teamSections.add(teamSection)
            }
            teamAdapter.notifyDataSetChanged()
        }.addOnFailureListener { exception ->
            Toast.makeText(requireContext(), exception.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }
}