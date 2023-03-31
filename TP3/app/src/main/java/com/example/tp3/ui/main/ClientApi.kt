package com.example.tp3.ui.main

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

const val BASEURL = "https://tp3.infomobile.app/api/v1/"
object ClientApi {
    val gson = GsonBuilder()
        .setLenient()
        .create()
    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(100, TimeUnit.SECONDS)
        .connectTimeout(100, TimeUnit.SECONDS)
        .build()
    private var retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    fun<T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}