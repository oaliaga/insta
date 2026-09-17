package com.oso.myapplication.domain.usecase

import com.oso.myapplication.domain.entity.UserEntity
import com.oso.myapplication.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(user:String,password:String): UserEntity?{
        val response:List<UserEntity> = authRepository.doLogin(user,password)

        return response.random()

    }
}