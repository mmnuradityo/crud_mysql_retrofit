package com.project_n.myapplication.Apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by amikom on 21/12/2018.
 */

object ApiService {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "http://192.168.100.236/Tracker_Tourism_Web/lib/"

    val dataUser: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }


}
