package com.example.networks7

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    private val client = OkHttpClient.Builder().build()

    private var gson = GsonBuilder()
        .setLenient()
        .create()

    val retrofit: Api = Retrofit.Builder()
        .baseUrl("https://worldtimeapi.org/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build().create(Api::class.java)

}