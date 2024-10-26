package com.example.purduepetecalendar.ui.course

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.purduepetecalendar.R

class CreateCourseFragment : Fragment() {

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