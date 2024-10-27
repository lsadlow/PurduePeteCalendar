package com.example.purduepetecalendar.ui.course

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.purduepetecalendar.MainActivity
import com.example.purduepetecalendar.R
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.time.DayOfWeek
import java.time.LocalTime

class AddCoursesActivity : AppCompatActivity() {

    private lateinit var layoutInflater: LayoutInflater
    lateinit var adapter : CourseListAdapter
    lateinit var items: MutableList<Course>
    fun addCourse(
        name: String,
        days: List<DayOfWeek>,
        startHour: Int,
        startMinute: Int,
        endHour: Int,
        endMinute: Int
    ) {
        items.add(
            Course(name, days, LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute))
        )
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcourses)
        items = readCoursesFromFile(this, "courses.dat") ?: mutableListOf()
        val listView = findViewById<ListView>(R.id.classList)

        adapter = CourseListAdapter(this, items)
        listView.adapter = adapter

        val addClassButton = findViewById<Button>(R.id.addCourseButton)
        addClassButton.setOnClickListener {
            openCreateCourseFragment()
        }
        val continueButton = findViewById<Button>(R.id.continueButton)
        continueButton.setOnClickListener {
            onContinue()
        }
    }

    private fun openCreateCourseFragment() {
        val frag = CreateCourseFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, frag)
        transaction.commit()
    }

    private fun onContinue() {
        writeCoursesToFile(this, "courses.dat", items)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun writeCoursesToFile(context: Context, fileName: String, courses: List<Course>) {
        try {
            context.openFileOutput(fileName, Context.MODE_PRIVATE).use { fileOut ->
                ObjectOutputStream(fileOut).use { objectOut ->
                    objectOut.writeObject(courses) // Serialize the list of courses
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun readCoursesFromFile(context: Context, fileName: String): MutableList<Course>? {
        // Use ObjectInputStream to read the serialized data from a file in internal storage
        return try {
            context.openFileInput(fileName).use { fileIn ->
                ObjectInputStream(fileIn).use { objectIn ->
                    objectIn.readObject() as MutableList<Course>
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}