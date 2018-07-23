package com.alpaye.rocketlaunchbrowser.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.OnClick
import com.alpaye.rocketlaunchbrowser.R
import com.alpaye.rocketlaunchbrowser.model.LaunchObjectResponseModel
import kotlinx.android.synthetic.main.layout_upcominglaunch_row.view.*
import android.support.v4.content.ContextCompat.startActivity
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import android.content.Intent
import com.alpaye.rocketlaunchbrowser.util.Util

class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(launch: LaunchObjectResponseModel) = with(itemView) {
        row_textview_launchname.text = launch.name
        row_textview_launchtime.text = launch.launchTime
        row_simpledraweeview_rocketimage.setImageURI(launch.rocketResponseModel?.rocketImageUrl)
        row_textview_launchlocation.text = launch.locationResponseModel?.launchLocation
        row_textview_rocketname.text = launch.rocketResponseModel?.rocketName

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