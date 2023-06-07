package com.example.persondetails

import android.app.Application
import com.example.persondetails.databse.Userdatabse
import com.example.persondetails.repository.UserRepo
import com.example.persondetails.userapi.UserApi
import com.example.persondetails.userapi.UserInstanse


class MainApplication:Application() {

    lateinit var userRepo: UserRepo

    override fun onCreate() {
        super.onCreate()

        val apiIns = UserInstanse.getInstanse().create(UserApi::class.java)

        val databse = Userdatabse.getInstance(applicationContext)

        val dao=Userdatabse.getInstance(applicationContext).userDao()
        userRepo = UserRepo(apiIns,databse,dao)

    }
}