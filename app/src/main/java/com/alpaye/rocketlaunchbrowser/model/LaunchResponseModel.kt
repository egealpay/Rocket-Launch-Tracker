package com.alpaye.rocketlaunchbrowser.model

import com.google.gson.annotations.SerializedName

data class LaunchResponseModel(
        @SerializedName("launches") val launchObject: List<LaunchObjectResponseModel>
)