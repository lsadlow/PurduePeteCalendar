package com.example.purduepetecalendar.ui.course

import android.os.Build
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.core.view.children
import com.example.purduepetecalendar.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.sql.Time
import java.time.DayOfWeek
import java.time.LocalTime

class CreateCourseFragment : Fragment() {
    lateinit var editText : EditText
    lateinit var chipGroup : ChipGroup
    lateinit var startTime : TimePicker
    lateinit var endTime : TimePicker
    lateinit var button : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_create_course, container, false)
        editText = view.findViewById<EditText>(R.id.courseName)
        chipGroup = view.findViewById<ChipGroup>(R.id.chip_group)
        startTime = view.findViewById<TimePicker>(R.id.startTimePicker)
        endTime = view.findViewById<TimePicker>(R.id.endTimePicker)
        button = view.findViewById<Button>(R.id.submitButton)

        button.setOnClickListener{
            onSubmit()
        }
        return view
    }

    private fun onSubmit() {
        val filteredDays : MutableList<DayOfWeek> = mutableListOf()
        chipGroup!!.children.forEachIndexed { index, chip ->
            if((chip as Chip).isChecked) {
                filteredDays.add(DayOfWeek.of(index + 1))
            }
        }
        println("LOG: " + filteredDays)
        val myactivity = activity as? AddCoursesActivity
        myactivity?.addCourse(editText?.text.toString(), filteredDays, startTime!!.hour, startTime!!.minute, endTime!!.hour, endTime!!.minute)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.remove(this)
        transaction.commit()
    }
}
