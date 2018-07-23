package com.alpaye.rocketlaunchbrowser.ui

import com.alpaye.rocketlaunchbrowser.model.LaunchResponseModel

class MainPresenter(var mainView: MainView?,
                    val mainInteractor: MainInteractor
) : MainInteractor.OnResponseListener {

    fun getUpcomingTen(upcomingLaunchNum: Int) {
        mainView?.showAnimation()
        mainInteractor.getTenUpcomingLaunches(this, upcomingLaunchNum)
    }

    fun onDestroy() {
        mainView = null
    }


    override fun onSuccessUpcomingTen(launchResponse: LaunchResponseModel?) {
        mainView?.showUpcomingTenLaunch(launchResponse)
        mainView?.stopAnimation()
    }

    override fun onError() {
        mainView?.showError()
    }

}