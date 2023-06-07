package com.example.persondetails.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.persondetails.dao.UserDao
import com.example.persondetails.databse.Userdatabse
import com.example.persondetails.model.UserDataItem
import com.example.persondetails.model.UserModelData
import com.example.persondetails.userapi.UserApi
import java.lang.Exception

class UserRepo(var userApi: UserApi, var userDatabse: Userdatabse, var userDao:UserDao) {

    private var userInfoMutable=MutableLiveData<UserModelData>()

     val userLiveData:LiveData<UserModelData>
         get()=userInfoMutable


    suspend fun getUserData() {

        try {
            val result = userApi.getUserinfo()
            result.body()?.let {
                userInfoMutable.postValue(result.body())
                userDatabse.userDao().InsertUser(result.body()!!)
                Log.d("data", result.body().toString())
            }
        } catch (exception: Exception) {
            exception.localizedMessage?.let { Log.d("error", it.toString()) }
        }
    }
        fun getAll(): LiveData<List<UserDataItem>> {
            return  userDao.GetAll()
        }

}