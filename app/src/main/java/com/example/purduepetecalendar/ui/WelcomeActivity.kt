package com.example.purduepetecalendar.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.purduepetecalendar.R
import android.widget.Button


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_page)

        val continueActivityButton = findViewById<Button>(R.id.nextButton)
        continueActivityButton.setOnClickListener {
            val Intent = Intent(this,ContinueActivity::class.java)
            startActivity(Intent)
        }

    }

}
