package com.alpaye.rocketlaunchbrowser.model

import com.google.gson.annotations.SerializedName

data class LaunchObjectResponseModel(
        @SerializedName("id") val id: Int? = null,
        @SerializedName("name") val name: String? = null,
        @SerializedName("net") val launchTime: String? = null,
        @SerializedName("location") val locationResponseModel: LocationResponseModel? = null,
        @SerializedName("rocket") val rocketResponseModel: RocketResponseModel? = null,
        @SerializedName("vidURLs") val videoURLs: ArrayList<String>? = null
)