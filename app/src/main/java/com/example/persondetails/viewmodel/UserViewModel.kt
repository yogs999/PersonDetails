package com.example.persondetails.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.persondetails.model.UserDataItem
import com.example.persondetails.model.UserModelData
import com.example.persondetails.repository.UserRepo
import kotlinx.coroutines.launch

class UserViewModel(private var userRepo: UserRepo):ViewModel() {

    init {
        viewModelScope.launch {
            userRepo.userDao
            userRepo.getUserData()
        }
    }

    val userLive:LiveData<UserModelData>
        get()=userRepo.userLiveData

    fun getAll(): LiveData<List<UserDataItem>> {
        return userRepo.getAll()
    }

}
