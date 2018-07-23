package com.alpaye.rocketlaunchbrowser.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.alpaye.rocketlaunchbrowser.model.LaunchObjectResponseModel
import kotlinx.android.synthetic.main.layout_upcominglaunch_row.view.*

class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(launch: LaunchObjectResponseModel) = with(itemView){
        row_textview_launchname.text = launch.name
        row_textview_launchtime.text = launch.launchTime
        row_simpledraweeview_rocketimage.setImageURI(launch.rocketResponseModel?.rocketImageUrl)
        row_textview_launchlocation.text = launch.locationResponseModel?.launchLocation
        row_textview_rocketname.text = launch.rocketResponseModel?.rocketName
    }

}