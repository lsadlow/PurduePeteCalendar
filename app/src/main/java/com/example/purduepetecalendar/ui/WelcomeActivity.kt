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




//        val viewSwitcher = findViewById<ViewSwitcher>(R.id.newswitcher)
//        val switchButton = findViewById<Button>(R.id.nextButton)
//        // Inflate and add your existing layouts to ViewSwitcher
//        val inflater = LayoutInflater.from(this)
//        val screen1 = inflater.inflate(R.layout.welcome_page, viewSwitcher, false)
//        val screen2 = inflater.inflate(R.layout.explanation_page, viewSwitcher, false)
//
//        viewSwitcher.addView(screen1)
//        viewSwitcher.addView(screen2)
//
//        // Set button to switch views
//        switchButton.setOnClickListener {
//            viewSwitcher.showNext()
//        }
    }

}
