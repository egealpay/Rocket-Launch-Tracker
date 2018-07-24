package com.alpaye.rocketlaunchbrowser.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.alpaye.rocketlaunchbrowser.model.LaunchObjectResponseModel
import kotlinx.android.synthetic.main.layout_upcominglaunch_row.view.*
import android.support.v4.content.ContextCompat.startActivity
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import android.content.Intent
import android.net.Uri
import com.alpaye.rocketlaunchbrowser.util.Util
import android.support.v4.content.ContextCompat.startActivity



class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(launch: LaunchObjectResponseModel) = with(itemView) {
        row_textview_launchname.text = launch.name
        row_textview_launchtime.text = launch.launchTime
        row_simpledraweeview_rocketimage.setImageURI(launch.rocketResponseModel?.rocketImageUrl)
        row_textview_launchlocation.text = launch.locationResponseModel?.launchLocation
        row_textview_rocketname.text = launch.rocketResponseModel?.rocketName

        if(launch.videoURLs?.size == 0){
            row_button_watchlive.visibility = View.GONE
        }
        else{
            row_button_watchlive.visibility = View.VISIBLE
        }

        row_button_watchlive.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(launch.videoURLs!![0]))
            startActivity(context, browserIntent, null)
        }

        row_button_addtocalendar.setOnClickListener {
            val calendarObject = Util.stringToDate(launch.launchTime!!)

            val calIntent = Intent(Intent.ACTION_INSERT)
            calIntent.type = "vnd.android.cursor.item/event"
            calIntent.putExtra(Events.TITLE, launch.name)

            calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false)
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    calendarObject.timeInMillis)
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    calendarObject.timeInMillis)

            startActivity(context, calIntent, null)
        }
    }

}