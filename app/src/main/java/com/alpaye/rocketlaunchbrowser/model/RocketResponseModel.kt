package com.alpaye.rocketlaunchbrowser.model

import com.google.gson.annotations.SerializedName

data class RocketResponseModel(
    @SerializedName("id") val rocketId: Int? = null,
    @SerializedName("name") val rocketName: String? = null,
    @SerializedName("imageURL") val rocketImageUrl: String? = null
)