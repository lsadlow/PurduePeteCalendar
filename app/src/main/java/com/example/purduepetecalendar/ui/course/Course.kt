package com.example.purduepetecalendar.ui.course

import java.io.Serializable
import java.time.DayOfWeek
import java.time.LocalTime

data class Course(val name : String, val days : List<DayOfWeek>, val startTime : LocalTime, val endTime : LocalTime) : Serializable