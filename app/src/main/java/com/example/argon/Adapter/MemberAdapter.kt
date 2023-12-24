package com.example.argon.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.argon.DataClass.TeamMember
import com.example.argon.R

class MemberAdapter(private val members: List<TeamMember>) :
    RecyclerView.Adapter<MemberAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wing_mem_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teamMember = members[position]
        holder.nameTextView.text = teamMember.name
        holder.roleTextView.text = teamMember.role
    }

    override fun getItemCount(): Int = members.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val roleTextView: TextView = itemView.findViewById(R.id.roleTextView)
    }
}
