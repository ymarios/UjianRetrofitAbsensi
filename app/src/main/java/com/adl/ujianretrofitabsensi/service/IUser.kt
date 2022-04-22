package com.adl.ujianretrofitabsensi.service

import com.adl.ujianretrofitabsensi.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface IUser {


    @Headers("X-Api-Key:6BA123CE43393D7A7505E3BF36490F99")
    @GET("api//ujianloginabsen/all?")
    fun getAll(@Query("limit") query:String): Call<UserResponse>

    @Headers("X-Api-Key:6BA123CE43393D7A7505E3BF36490F99")
    @GET("api//ujianloginabsen/all?")
    fun login(@Query("filter")query: String): Call<UserResponse>


}