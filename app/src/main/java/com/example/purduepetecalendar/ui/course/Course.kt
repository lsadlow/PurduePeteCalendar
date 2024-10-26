package com.example.purduepetecalendar.ui.course

import java.time.LocalTime

data class Course(val name : String, val days : List<String>, val startTime : LocalTime, val endTime : LocalTime)