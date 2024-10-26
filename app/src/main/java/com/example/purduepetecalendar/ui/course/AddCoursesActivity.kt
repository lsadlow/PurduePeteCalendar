package com.example.purduepetecalendar.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.purduepetecalendar.R
import java.time.LocalTime

class AddCoursesActivity : AppCompatActivity() {
    private lateinit var layoutInflater: LayoutInflater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcourses)
        val listView = findViewById<ListView>(R.id.classList)
        val items = listOf(
            Course("MA 261", listOf("M", "W", "F"), LocalTime.of(3, 30), LocalTime.of(4, 20)),
            )
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