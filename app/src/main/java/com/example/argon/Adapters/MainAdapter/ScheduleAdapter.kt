package com.example.argon.Adapters.MainAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.argon.DataClass.Schedule
import com.example.argon.R

class ScheduleAdapter(private val sche: List<Schedule>) :
    RecyclerView.Adapter<ScheduleAdapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.schedule_layout, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return sche.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val schedule = sche[position]
        holder.scheText.text = schedule.match
        holder.scheTime.text = schedule.time
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val scheText:TextView = itemView.findViewById(R.id.sportText)
        val scheTime:TextView = itemView.findViewById(R.id.sportTime)
    }
}