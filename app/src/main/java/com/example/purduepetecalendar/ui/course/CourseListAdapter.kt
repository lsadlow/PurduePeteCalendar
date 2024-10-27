package com.example.purduepetecalendar.ui.course

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.purduepetecalendar.R
import java.time.format.TextStyle
import java.util.Locale

class CourseListAdapter(private val ctx: Context, private val dataList: List<Course>) : BaseAdapter() {
    private val inflater : LayoutInflater = LayoutInflater.from(ctx)
    override fun getCount() : Int = dataList.size
    override fun getItem(position: Int): Any = dataList[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.activity_course_item, parent, false)

        // Get the current item data
        val item = dataList[position]

        // Populate the layout's TextViews with data
        val titleTextView = view.findViewById<TextView>(R.id.course_desc)

        var text : String = item.name + " "
        for (d in item.days)  {
            text += d.getDisplayName(TextStyle.SHORT, Locale.US)
        }
        text += " " + item.startTime + "-" + item.endTime
        titleTextView.text = text
        return view
    }
}