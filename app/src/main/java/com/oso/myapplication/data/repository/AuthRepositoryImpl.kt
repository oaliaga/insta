package com.oso.myapplication.data.repository

import com.oso.myapplication.data.response.UserResponse
import com.oso.myapplication.data.response.toDomain
import com.oso.myapplication.domain.entity.UserEntity
import com.oso.myapplication.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    override fun doLogin(user: String, paswword: String): UserEntity {
        val userResponse: UserResponse = UserResponse(
            userId = "",
            name = "",
            nickname = "",
            followers = 10,
            following = listOf(""),
            userType = 0
        )
        return userResponse.toDomain()
    }

}