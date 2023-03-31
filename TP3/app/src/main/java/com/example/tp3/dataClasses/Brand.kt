package com.example.tp3.dataClasses

import com.google.gson.annotations.SerializedName

data class Brand(
    val id:Int?,
    val name:String
)

data class BrandLists(
    @SerializedName("content") val brands : List<Brand>
)
