package com.example.persondetails.userapi


import com.example.persondetails.model.UserModelData
import retrofit2.Response
import retrofit2.http.GET

interface UserApi  {

    @GET("posts")
    suspend fun getUserinfo() : Response<UserModelData>

}