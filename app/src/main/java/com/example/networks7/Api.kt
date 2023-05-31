package com.example.networks7

import com.example.networks7.model.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Api {

    @Headers("Content-Type: application/json")
    @GET("api/ip/{ip}")
    suspend fun getData(@Path("ip") ip: String): Response<Data>
}