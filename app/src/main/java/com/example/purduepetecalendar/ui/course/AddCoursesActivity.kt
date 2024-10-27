package com.example.purduepetecalendar.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.purduepetecalendar.R
import java.time.DayOfWeek
import java.time.LocalTime

class AddCoursesActivity : AppCompatActivity() {

    private lateinit var layoutInflater: LayoutInflater
    lateinit var courseName: String

    var items: MutableList<Course> = mutableListOf()

    fun createCourse(
        name: String,
        days: List<DayOfWeek>,
        startHour: Int,
        startMinute: Int,
        endHour: Int,
        endMinute: Int
    ): Course {
        return Course(
            name,
            days,
            LocalTime.of(startHour, startMinute),
            LocalTime.of(endHour, endMinute)
        )
    }


    fun addItem(course: Course): Unit {
        items.add(0, course)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcourses)
        val listView = findViewById<ListView>(R.id.classList)
        val adapter = CourseListAdapter(this, items)
        listView.adapter = adapter

        val addClassButton = findViewById<Button>(R.id.addCourseButton)
        addClassButton.setOnClickListener {
            openCreateCourseFragment()
        }
    }

    private fun openCreateCourseFragment() {
        val frag = CreateCourseFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, frag)
        transaction.commit()
    }
}