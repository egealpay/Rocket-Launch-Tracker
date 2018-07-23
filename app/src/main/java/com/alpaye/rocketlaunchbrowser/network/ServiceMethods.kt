package com.alpaye.rocketlaunchbrowser.network

import com.alpaye.rocketlaunchbrowser.model.LaunchResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceMethods {

    @GET("/1.4/launch/next/{num}")
    fun getTenUpcomingLaunchs(@Path("num") num: Int): Call<LaunchResponseModel>

}