package com.example.tp3.ui.main

import com.example.tp3.BuildConfig
import com.example.tp3.dataClasses.*
import com.google.gson.annotations.SerializedName
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*


interface InterfaceApi {

    @GET("brand/")
    fun listbrand(): Call<BrandLists>

//    @GET("brand/{id}/models/")
//    fun listbrandmodel(@Path("id") id: Int): Call<List<Model>>
//
//    @GET("model/")
//    fun listmodel(): Call<List<Model>>
//
//    @GET("offer/search/")
//    fun listsearch(@Query("model") model: Int, @Query("brand") brand: Int): Call<List<SeachOffer>>
//
//    @POST("offer/add/")
//    fun addOffer(@Body Body: Map<String, String>, @Header("Authorization") token: String): Call<DetailOffer>
//
//    @GET("offer/mine/")
//    fun myOffer(@Header("Authorization") token: String): Call<List<SeachOffer>>
//
//    @GET("offer/{id}/details/")
//    fun detailoffer(@Path("id") id: Int): Call<DetailOffer>
//
//    @Headers("Content-Type: application/json")
//    @POST("account/login/")
//    fun login(@Body Body: Map<String, String>): Call<Token>
//
//    @GET("account/me/")
//    fun getaccount(@Header("Authorization") token: String): Call<Account>

}