package com.alpaye.rocketlaunchbrowser.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alpaye.rocketlaunchbrowser.R
import com.alpaye.rocketlaunchbrowser.model.LaunchObjectResponseModel

class LaunchAdapter(
        private val launchList: ArrayList<LaunchObjectResponseModel> = ArrayList()
): RecyclerView.Adapter<LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LaunchViewHolder(LayoutInflater
    .from(parent.context)
    .inflate(R.layout.layout_upcominglaunch_row, parent, false))

    override fun getItemCount() = launchList.size

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) = holder.bindView(launchList[position])

    fun updateList(coins: ArrayList<LaunchObjectResponseModel>) {
        coins.let {
            launchList.addAll(it)
            notifyDataSetChanged()
        }
    }
}