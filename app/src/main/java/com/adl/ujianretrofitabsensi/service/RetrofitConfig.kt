package com.adl.ujianretrofitabsensi.service

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient

    }

    fun getRetrofitClientInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.114/cicool/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getRetro() = getRetrofitClientInstance().create(IUser::class.java)
}