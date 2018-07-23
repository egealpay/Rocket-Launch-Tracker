package com.alpaye.rocketlaunchbrowser.model

import com.google.gson.annotations.SerializedName

data class LocationResponseModel(
    @SerializedName("name") val launchLocation: String? = null,
    @SerializedName("countryCode") val countryCode: String? = null
)