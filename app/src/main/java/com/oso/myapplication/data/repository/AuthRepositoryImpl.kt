package com.oso.myapplication.data.repository

import android.util.Log
import com.oso.myapplication.data.datasource.api.ApiServices
import com.oso.myapplication.data.response.UserResponse
import com.oso.myapplication.data.response.toDomain
import com.oso.myapplication.domain.entity.UserEntity
import com.oso.myapplication.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor (val api: ApiServices) : AuthRepository {

    override suspend fun doLogin(user: String, paswword: String): List<UserEntity> {
        val response: List<UserResponse> = try{
            api.doLogin()
        }catch (e: Exception){
            Log.i("LOG","error:${e.message}")
            listOf()
        }
        return response.map { it.toDomain() }

/*
        val userResponse: UserResponse = UserResponse(
            userId = "",
            name = "",
            nickname = "",
            followers = 10,
            following = listOf(""),
            userType = 0
        )
        return userResponse.toDomain()*/
    }

}