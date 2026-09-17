package com.oso.myapplication.data.datasource.api

import com.oso.myapplication.data.response.UserResponse
import retrofit2.http.GET

interface ApiServices {
    @GET("doLogin/.json")
    suspend fun doLogin():List<UserResponse>

}