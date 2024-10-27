package com.example.purduepetecalendar.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.purduepetecalendar.R
import com.example.purduepetecalendar.ScheduleAdapter
import com.example.purduepetecalendar.ui.course.AddCoursesActivity

class ContinueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explanation_page)

        val AddCoursesActivityButton = findViewById<Button>(R.id.button2)
        AddCoursesActivityButton.setOnClickListener {
            val Intent = Intent(this,AddCoursesActivity::class.java)
            startActivity(Intent)
        }

    }

}