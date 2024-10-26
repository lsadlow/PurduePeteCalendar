package com.example.purduepetecalendar

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.CalendarView
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.purduepetecalendar.databinding.ActivityMainBinding
import com.example.purduepetecalendar.ui.course.Course
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    // on below line we are creating
    // variables for text view and calendar view
    lateinit var dateTV: TextView
    lateinit var schedule: TextView
    lateinit var calendarView: CalendarView
    lateinit var listView: ListView
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initializing variables of
        // list view with their ids.
        dateTV = findViewById(R.id.idTVDate)
        schedule = findViewById(R.id.scheduleContent)
        calendarView = findViewById(R.id.calendarView)
        listView = findViewById(R.id.listView)
        val today = LocalDate.now()
        val dayOfWeek = today.dayOfWeek

        val allCourses = readCoursesFromFile(this, "courses.dat")?: mutableListOf()
        val adapter = ScheduleAdapter(this,
            filterCoursesByDay(allCourses, dayOfWeek)
        )
        listView.adapter = adapter

        // on below line we are adding set on
        // date change listener for calendar view.
        calendarView.setOnDateChangeListener(
            CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                // In this Listener we are getting values
                // such as year, month and day of month
                // on below line we are creating a variable
                // in which we are adding all the variables in it.
                val dayOfWeek = getDayOfWeek(year, month, dayOfMonth)
                val courses = filterCoursesByDay(allCourses, dayOfWeek)
                adapter.updateCourses(courses)
                val Date = ("Schedule for " + (month + 1) + "/" + dayOfMonth.toString()
                        + "/" + year + ":")

                // set this date in TextView for Display
                dateTV.setText(Date)
            })
    }

    fun writeCoursesToFile(context: Context, fileName: String, courses: List<Course>) {
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

    fun readCoursesFromFile(context: Context, fileName: String): MutableList<Course>? {
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

    fun getDayOfWeek(year: Int, month: Int, dayOfMonth: Int) : DayOfWeek {
        return LocalDate.of(year, month + 1, dayOfMonth).dayOfWeek
    }

    fun filterCoursesByDay(courses: MutableList<Course>, targetDay: DayOfWeek) : MutableList<Course> {
        return courses.filter { course ->
            targetDay in course.days
        } as MutableList<Course>
    }
}