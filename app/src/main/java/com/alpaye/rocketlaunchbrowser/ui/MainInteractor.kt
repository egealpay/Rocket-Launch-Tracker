package com.alpaye.rocketlaunchbrowser.ui

import com.alpaye.rocketlaunchbrowser.model.LaunchResponseModel
import com.alpaye.rocketlaunchbrowser.network.RetrofitClientInstance
import com.alpaye.rocketlaunchbrowser.network.ServiceMethods
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainInteractor {

    interface OnResponseListener {
        fun onSuccessUpcomingTen(launchResponse: LaunchResponseModel?)
        fun onError()
    }

    private var serviceMethods: ServiceMethods? = null

    fun getTenUpcomingLaunches(listener: OnResponseListener, upcomingLaunchNum: Int) {
        if (serviceMethods == null) {
            serviceMethods = RetrofitClientInstance.getRetrofitCient().create(ServiceMethods::class.java)
        }

        serviceMethods?.getTenUpcomingLaunchs(upcomingLaunchNum)?.enqueue(object : Callback<LaunchResponseModel> {
            override fun onResponse(call: Call<LaunchResponseModel>?, response: Response<LaunchResponseModel>?) {
                listener.onSuccessUpcomingTen(response?.body())
            }

            override fun onFailure(call: Call<LaunchResponseModel>?, t: Throwable?) {
                listener.onError()
            }
        })
    }
}