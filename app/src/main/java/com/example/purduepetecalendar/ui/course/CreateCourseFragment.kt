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
import androidx.annotation.RequiresApi
import com.example.purduepetecalendar.R
import java.time.DayOfWeek
import java.time.LocalTime

class CreateCourseFragment : Fragment() {
    val editText = view?.findViewById<EditText>(R.id.courseName)
    val button = view?.findViewById<Button>(R.id.submitButton)

    @RequiresApi(Build.VERSION_CODES.O)
    private fun someMethodToCreateCourse() {
        (activity as? AddCoursesActivity)?.let { activity ->
            val course =
                activity.createCourse("Placeholder", listOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY),3, 30,4, 20)
            // Do something with the created course, like updating the UI or saving it
        }
    }

    /*
    @RequiresApi(Build.VERSION_CODES.O) // test course
    var myCourse: Course = AddCoursesActivity.createCourse("Placeholder", listOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY),3, 30,4, 20)

    @RequiresApi(Build.VERSION_CODES.O)
    public fun addCourseToActivity(course: Course) {
        // Safely cast the activity to AddCoursesActivity
        (activity as? AddCoursesActivity)?.let { activity ->
            activity.addItem(myCourse)
        }
    }

    (addCourseToActivity(myCourse))
*/

    companion object {
        fun newInstance() = CreateCourseFragment()
    }

    private val viewModel: CreateCourseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_create_course, container, false)
    }
}