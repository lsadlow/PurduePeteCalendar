package com.example.purduepetecalendar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.purduepetecalendar.ui.course.Course

class ScheduleAdapter(private val context: Context, private val courseList: MutableList<Course>) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun getCount() : Int = courseList.size

    override fun getItem(position: Int): Course = courseList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView?: inflater.inflate(R.layout.schedule_item, parent, false)
        val item = courseList[position]
        val courseNameView = view.findViewById<TextView>(R.id.courseName)
        val courseTimesView = view.findViewById<TextView>(R.id.courseTimes)

        courseNameView.text = item.name
        courseTimesView.text = buildString {
            append("")
            append(item.startTime)
            append("-")
            append(item.endTime)
        }

        return view
    }

    fun updateCourses(newCourses: List<Course>) {
        courseList.clear() // Clear the current list
        courseList.addAll(newCourses) // Add the new courses
        notifyDataSetChanged() // Notify that the data has changed
    }

}