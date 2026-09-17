package com.oso.myapplication.domain.repository

import com.oso.myapplication.domain.entity.UserEntity

interface  AuthRepository{
    suspend fun doLogin(user:String,paswword:String): List<UserEntity>
}