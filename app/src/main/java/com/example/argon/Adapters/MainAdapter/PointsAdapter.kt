package com.example.argon.Adapters.MainAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.argon.R

class PointsAdapter(private val points:List<PointsAdapter>):RecyclerView.Adapter<PointsAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.point_table_layout,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return points.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

    }

    class viewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val clgName:TextView = itemView.findViewById(R.id.collegeName)
        val totMatch:TextView = itemView.findViewById(R.id.totalMatch)
        val win:TextView = itemView.findViewById(R.id.win)
        val lose:TextView = itemView.findViewById(R.id.loss)
    }
}