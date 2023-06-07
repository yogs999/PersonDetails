package com.example.persondetails.userapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val base_Url= "https://jsonplaceholder.typicode.com/"

object UserInstanse {

     fun getInstanse():Retrofit{
        return Retrofit.Builder()
            .baseUrl(base_Url).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}