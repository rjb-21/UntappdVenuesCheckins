package com.example.untappdvenuescheckins

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ViewHolder(v: View) {
    val tvTitle: TextView = v.findViewById(R.id.tvTitle)
    val tvPubDate: TextView = v.findViewById(R.id.tvPubDate)
    val tvDescription: TextView = v.findViewById(R.id.tvDescription)
}

class FeedAdapter(
    context: Context,
    private val resource: Int,
    private val applications: List<FeedEntry>
) : ArrayAdapter<FeedEntry>(context, resource) {
    private val TAG = "FeedAdapter"
    private val inflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        Log.d(TAG, "getCount() called")
        Log.d(TAG, "applications.size: ${applications.size}")
        return applications.size

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        Log.d(TAG, "getView() called")


        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
//            list_item.xml.d(TAG, "getView called with null convertView")
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            Log.d(TAG, "getView provided convertView")
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


        val currentApp = applications[position]

        viewHolder.tvTitle.text = currentApp.title
        viewHolder.tvPubDate.text = currentApp.pubDate
        viewHolder.tvDescription.text = currentApp.description

        return view
    }
}