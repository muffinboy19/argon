package com.example.argon.Fragments.MainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.argon.Adapters.MainAdapter.ScheduleAdapter
import com.example.argon.DataClass.Schedule
import com.example.argon.databinding.FragmentScheduleBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Schedule : Fragment() {
    private lateinit var binding: FragmentScheduleBinding
    private var schedule: MutableList<Schedule> = mutableListOf()
    private lateinit var scheduleAdapter: ScheduleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scheduleAdapter = ScheduleAdapter(schedule)
        binding.scheduleRv.adapter = scheduleAdapter
        binding.scheduleRv.layoutManager = LinearLayoutManager(requireContext())

        fetchFromFirebase()
    }

    private fun fetchFromFirebase() {
        schedule.clear()
        val db = FirebaseFirestore.getInstance()
        db.collection("Schedule").orderBy("no").get().addOnSuccessListener { documents ->
            val currentTime = Calendar.getInstance().time
            for (document in documents) {
                val match = document.getString("name") ?: ""
                val time = document.getTimestamp("time")?.toDate()
                if (time != null && time > currentTime) {
                    val formattedTime = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(time)
                    schedule.add(Schedule(match, formattedTime))
                }
            }
            scheduleAdapter.notifyDataSetChanged()
        }.addOnFailureListener { exception ->
            Toast.makeText(
                requireContext(), exception.localizedMessage,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}