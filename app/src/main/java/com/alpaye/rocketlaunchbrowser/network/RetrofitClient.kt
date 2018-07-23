package com.alpaye.rocketlaunchbrowser.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    companion object {
        val BASE_URL = "https://launchlibrary.net/"

        var INSTANCE: Retrofit? = null

        fun getRetrofitCient(): Retrofit {
            if (INSTANCE == null) {
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return INSTANCE!!
        }
    }
}