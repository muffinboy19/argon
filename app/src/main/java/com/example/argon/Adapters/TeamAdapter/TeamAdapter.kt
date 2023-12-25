package com.example.argon.Adapters.TeamAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.argon.DataClass.TeamSection
import com.example.argon.R

class TeamAdapter(val context: Context, private val teamSections: List<TeamSection>) :
    RecyclerView.Adapter<TeamAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wing_layout, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val teamSection = teamSections[position]
        holder.sectionNameTextView.text = teamSection.sectionName

        val memberAdapter = MemberAdapter(teamSection.members)
        holder.membersRecyclerView.adapter = memberAdapter
        holder.membersRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun getItemCount(): Int = teamSections.size

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sectionNameTextView: TextView = itemView.findViewById(R.id.wingName)
        val membersRecyclerView: RecyclerView = itemView.findViewById(R.id.wingMembersRv)
        init {
            membersRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
        }
    }
}
