package com.oso.myapplication.domain.repository

import com.oso.myapplication.domain.entity.UserEntity

interface  AuthRepository{
    fun doLogin(user:String,paswword:String): UserEntity
}