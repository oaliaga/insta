package com.oso.myapplication.domain.usecase

import com.oso.myapplication.domain.repository.AuthRepository

class Login(val authRepository: AuthRepository) {

    operator fun invoke(user:String,password:String){
        val response:Boolean=authRepository.doLogin(user,password)
    }
}