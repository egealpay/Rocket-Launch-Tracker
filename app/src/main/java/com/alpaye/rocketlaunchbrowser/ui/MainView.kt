package com.alpaye.rocketlaunchbrowser.ui

import com.alpaye.rocketlaunchbrowser.model.LaunchResponseModel


interface MainView {

    fun showUpcomingTenLaunch(
            launchResponse: LaunchResponseModel?
    )

    fun showError()

}