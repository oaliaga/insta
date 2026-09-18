package com.oso.myapplication.data.response

import com.oso.myapplication.domain.entity.UserEntity
import com.oso.myapplication.domain.entity.UserMode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import javax.annotation.meta.TypeQualifierNickname
@Serializable
data class UserResponse(
    val userId:String,
    val name:String,
    @SerialName("nickName") val nickname: String,
    val followers:Int=0,
    val following:List<String> = emptyList(),
    val userType:Int
)

fun UserResponse.toDomain(): UserEntity{
    val userMode = when(userType){
        UserMode.REGULAR_USER.usergiType -> UserMode.REGULAR_USER
        UserMode.CONTENT_CREATOR_USER.userType -> UserMode.CONTENT_CREATOR_USER
        UserMode.COMPANY_USER.userType -> UserMode.COMPANY_USER
        else ->UserMode.REGULAR_USER
    }
    return UserEntity(
        userId= userId,
        name=name,
        nickname=nickname,
        followers=followers,
        following=following,
        userMode = userMode
    )
}